package main

import (
        "database/sql"
        "fmt"
        _ "github.com/go-sql-driver/mysql"
        "reflect"
)

func main() {
        /*DSN数据源名称
          [username[:password]@][protocol[(address)]]/dbname[?param1=value1¶mN=valueN]
          user@unix(/path/to/socket)/dbname
          user:password@tcp(localhost:5555)/dbname?charset=utf8&autocommit=true
          user:password@tcp([de:ad:be:ef::ca:fe]:80)/dbname?charset=utf8mb4,utf8
          user:password@/dbname
          无数据库: user:password@/
        */
        db, err := sql.Open("mysql", "root:root@tcp(127.0.0.1:3306)/?charset=utf8") //第一个参数为驱动名  
        checkErr(err)
        db.Query("drop database if exists tmpdb")
        db.Query("create database tmpdb")
        //db.Query("use tmpdb")
        db.Query("create table tmpdb.tmptab(c1 int, c2 varchar(20), c3 varchar(20))")
        db.Query("insert into tmpdb.tmptab values(101, '姓名1', 'address1'), (102, '姓名2', 'address2'), (103, '姓名3', 'address3'), (104, '姓名4', 'address4')")
        //checkErr(err)
        query, err := db.Query("select * from tmpdb.tmptab")

        checkErr(err)
        v := reflect.ValueOf(query)
        fmt.Println(v)
        fmt.Println("--增加数据测试--")
        printResult(query)
        db.Query("delete from tmpdb.tmptab where c1 = 101")
        //checkErr(err)
        query2, _ := db.Query("select * from tmpdb.tmptab")
        fmt.Println("--删除数据测试--")
        printResult(query2)
        db.Query("update tmpdb.tmptab set c3 = 'address4' where c1 = 103")
        //checkErr(err)
        query3, _ := db.Query("select * from tmpdb.tmptab")
        fmt.Println("--更新数据测试--")
        printResult(query3)
        db.Query("delete from tmpdb.tmptab")
        //checkErr(err)
        query4, _ := db.Query("select * from tmpdb.tmptab")
        fmt.Println("--清空数据测试--")
        printResult(query4)
        db.Query("drop table tmpdb.tmptab")
        db.Query("drop database tmpdb")
        //stmt, err := db.Prepare("create database tmpdb")
        db.Close()
}

func checkErr(errMasg error) {
        if errMasg != nil {
                panic(errMasg)
        }
}

func printResult(query *sql.Rows) {
        column, _ := query.Columns()              //读出查询出的列字段名
        values := make([][]byte, len(column))     //values是每个列的值，这里获取到byte里
        scans := make([]interface{}, len(column)) //因为每次查询出来的列是不定长的，用len(column)定住当次查询的长度
        for i := range values {                   //让每一行数据都填充到[][]byte里面
                scans[i] = &values[i]
        }
        results := make(map[int]map[string]string) //最后得到的map
        i := 0
        for query.Next() { //循环，让游标往下移动
                if err := query.Scan(scans...); err != nil { //query.Scan查询出来的不定长值放到scans[i] = &values[i],也就是每行都放在values里
                        fmt.Println(err)
                        return
                }
                row := make(map[string]string) //每行数据
                for k, v := range values {     //每行数据是放在values里面，现在把它挪到row里
                        key := column[k]
                        row[key] = string(v)
                }
                results[i] = row //装入结果集中
                i++
        }
        for k, v := range results { //查询出来的数组
                fmt.Println(k, v)
        }
}
