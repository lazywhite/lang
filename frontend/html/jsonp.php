<?php
$callback = $_REQUEST['callback'];
$data = ['val1', 'val2'];
echo $callback . '(' . json_encode($data) . ')';
