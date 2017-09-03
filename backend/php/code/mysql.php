<?php
/**
 * Short description for mysql.php
 *
 * @package mysql
 * @author white <white@Whites-Mac-Air.local>
 * @version 0.1
 * @copyright (C) 2017 white <white@Whites-Mac-Air.local>
 * @license MIT
 */

$host = "localhost";
$username = "root";
$password = "root";
$db = "test";

try{
    $conn = new mysqli($host, $username, $password, $db);
    
    if ($conn->connect_error) {
        die("连接失败: " . $conn->connect_error);
    }
    echo "连接成功";
    $sql = "select * from user where id = ?";
    $id = 4;
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $id);
    $stmt->execute();

    $result = $stmt->get_result();
    $rows = $result->fetch_assoc();

}catch(Exception $e){
    echo $e->getMessage();
}finally{
    $conn->close();
}

?>
