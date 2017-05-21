package com.local.test;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by white on 17/5/21.
 */
public class MongoUtil {

    /**
     * Java + MongoDB Hello world Example
     *
     */
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB = "new";

    public static void run() {
        try {
            ServerAddress  addr = new ServerAddress(HOST, PORT);
            MongoClient mongo = new MongoClient(addr);

            MongoDatabase db = mongo.getDatabase(DB);

            //从Mongodb中获得名为yourColleection的数据集合，如果该数据集合不存在，Mongodb会为其新建立
            MongoCollection<Document> collection = db.getCollection("test");

            // 使用BasicDBObject对象创建一个mongodb的document,并给予赋值。
            Document document = new Document();
            document.put("id", 1001);
            document.put("msg", "hello world mongoDB in Java");
            //将新建立的document保存到collection中去
            collection.insertOne(document);
            // 创建要查询的document
            Document searchQuery = new Document();
            searchQuery.put("id", 1001);
            // 使用collection的find方法查找document
            FindIterable<Document> docs = collection.find(searchQuery);
            MongoCursor<Document> iter = docs.iterator();
            //循环输出结果
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
