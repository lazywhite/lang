import MySQLdb
 
try:
    conn=MySQLdb.connect(host='localhost',user='root',passwd='dbroot',port=3306)
    cur=conn.cursor()
     
    conn.select_db('monitor')
 
    count=cur.execute('select * from django_content_type')
    print 'there has %s rows record' % count
 
    result=cur.fetchone()
    print result
 
    results=cur.fetchmany(5)
    for r in results:
        print r
 
    print '=='*10
    cur.scroll(0,mode='absolute')
 
    results=cur.fetchall()
    for r in results:
        print r[1]
     
 
    conn.commit()
    cur.close()
    conn.close()
 
except MySQLdb.Error,e:
     print "Mysql Error %d: %s" % (e.args[0], e.args[1])
