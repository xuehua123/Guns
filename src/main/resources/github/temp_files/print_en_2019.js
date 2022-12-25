function doPrint(){
  var str = '<!DOCTYPE html><html><head>';
  str += '<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />';
  str += '<title>'+document.title+'</title>';
  str += '<link href="https://t4.chei.com.cn/chsi/css/report/xlReport-2018.css?v=20190318" rel="stylesheet">';
  str +='</head>';
  str +='<body onload="window.print()">'+document.getElementById("resultTable").innerHTML + '</body></html>';
  w = window.open("", "", "");
  w.document.write(str);
  w.document.close();
}
