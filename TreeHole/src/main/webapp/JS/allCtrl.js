/**
 * Created by wangyiheng on 2018/7/23.
 */
//Ajax
    var xmlhttp;
    function loadXMLDoc(url,cfunc){
        if(window.XMLHttpRequest){
            xmlhttp = new XMLHttpRequest();
        }
        else{
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = cfunc;
        xmlhttp.open("POST",url,true);
        xmlhttp.send();
    }
    function myFucntion(){
        loadXMLDoc("/User/register",function(){
            if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                var jsonp = "[{";
                $("#register").each(function(index,item){
                    if(index <7&&index > 0){
                        jsonp += "'" + item.name + ":" + item.value + "'";
                        if(index == 6){
                            jsonp += "}]";
                        }
                        else{
                            jsonp += "},{";
                        }
                    }
                });
                return JSON.stringify(jsonp);
            }
        })
        //��Ӻ�̨���ݵ��������
        function manegeFucntion(xml){
            var xmlDoc = xml.responseXML;
            var tab = $("#userTb")[0];
            var x = xmlDoc.getElementsByName("User");
            x.each(function(index,item){
                tab += "<tr><td>"+ item.userId +"</td><td>"+item.nickname +"</td><td>"+item.password +"</td><td>"+item.gender +"</td><td>"+item.age +"</td><td>"+ item.realname +"</td><td>"+item.info +"</td>"+"<td><button id='btn1' onclick='newLoadXMLDoc()'><a href='../newManage.html'>����</a></button></td>"+"<td><button id='btn2' onclick='deleteXMLDoc()'><a href='../newManage.html'>ɾ��</a></button></td></tr>";
            })
        }
    }
        //��������
        function newLoadXMLDoc(){
            if(window.XMLHttpRequest){
                xmlhttp = new XMLHttpRequest();
            }
            else{
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                    var jsonp = "[{";
                    $("#register").each(function(index,item){
                        if(index <7&&index > 0){
                            jsonp += "'" + item.name + ":" + item.value + "'";
                            if(index == 6){
                                jsonp += "}]";
                            }
                            else{
                                jsonp += "},{";
                            }
                        }
                    });
                    return JSON.stringify(jsonp);
                }
            };
            xmlhttp.open("POST","/User/updateUserInfo",true);
            xmlhttp.send();
        }
        //ɾ����̨����
        function deleteXMLDoc() {
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            }
            else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    return $(this).parentNode.childNodes[0].value;
                }
            };
            xmlhttp.open("GET","/User/deleteUserById",true);
            xmlhttp.send();
        }
    function loginLoadXMLDoc(){
        if(window.XMLHttpRequest){
            xmlhttp = new XMLHttpRequest();
        }
        else{
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.open("POST","/User/doLogin",true);
        xmlhttp.send();
    }
