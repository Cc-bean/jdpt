
/!*已解决*!/
var yespage=false;
function show_hidenyes(t) {
    if(yespage==false){
        document.getElementById("yespage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        yespage=true;
    }else {
        document.getElementById("yespage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        yespage=false;
    }
}






var yeslist=[];
var yestotalpage=1;
var yesnowcount=0;
yesgodown();
//点击查看党员详情
function showyes(t){
    var yesitem=parseInt(t.id.substring(2));
    var yesmask=document.getElementById("yesmask");

    var str="";
    str+="<div class='dycard'><table cellpadding='0' cellspacing='0'><tr><td>反馈标题：</td><td>";
    str+=yeslist[yesitem][0]+"</td></tr><tr><td>反馈类型：</td><td>";
    str+=yeslist[yesitem][1]+"</td></tr><tr><td>受理单位：</td><td>";
    str+=yeslist[yesitem][2]+"</td></tr><tr><td>受理时间：</td><td>";
    str+=yeslist[yesitem][4].substring(0,10)+"</td></tr><tr><td>提交时间：</td> <td>";
    str+=yeslist[yesitem][3].substring(0,10)+" </td></tr><tr><td>处理内容：</td><td>";
    str+=yeslist[yesitem][5]+" </td></tr><tr><td>反馈内容：</td><td>";
    str+=yeslist[yesitem][6]+" </td></tr><tr><td>反馈图片：</td><td>";
    if(yeslist[yesitem][7]=="未录入"){
        str+="无";
    }else {
        var imgs=yeslist[yesitem][5].split(",");
        for(var i=0;i<imgs.length;i++){
            str+="<img style='position: relative;width: 100%;border-radius: 0.2rem;' src='http://47.105.118.98/HJResourse/Feedback/"+imgs[i]+"'/>"
        }
    }
    str+="</td></tr></table></div>";
    yesmask.innerHTML=str;
    showmask(yesmask);
}




function yesgojumppage() {
    dynowcount=document.getElementById("yestopage").value;
    getyeslist();
}

function getyeslist() {
    showmask(loadmask);
    var year=document.getElementById("getyear").value;
    var userId=sessionStorage.getItem("userId");
    $.ajax({
        url:'/jdpt/YichuliSearch/'+userId+"/"+year+"/"+yesnowcount+"/10",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            console.log(mes);
            //总页数
            if(mes.total==0){
                document.getElementById("yeslist").innerHTML="<img style='z-index: 10000;position: relative;width: 100%' src='/jdpt/static/img/null.png'/>"

            }else {
            document.getElementById("yeslist").innerHTML="";
            yeslist.length=0;
            yestotalpage=mes.total;
            //当前页
            yesnowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("yes_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var yespagestr="";
            for(var i=1;i<=mes.total;i++){
                yespagestr+="<option value='"+i+"'>"+i+"</option>";
            }

            document.getElementById("yestopage").innerHTML=yespagestr;
            for(var i=0;i<mes.record.length;i++){

                var fTitle="";
                mes.record[i].fTitle==null? fTitle="未录入": fTitle=mes.record[i].fTitle;
                var backtype="";
                mes.record[i].backtype.bType==null?backtype="未录入":backtype=mes.record[i].backtype.bType;
                var sldw="";
                if(mes.record[i].department==null||mes.record[i].zhen!=null){
                    sldw=mes.record[i].zhen.zName;
                }else if(mes.record[i].department!=null||mes.record[i].zhen==null){
                    sldw=mes.record[i].department.dName;
                }else {
                    sldw="未录入";
                }
                var fTime="";
                mes.record[i].fTime==null?fTime="未录入":fTime=mes.record[i].fTime;
                var frTime=""
                mes.record[i].feedbackreply.frTime==null?frTime="未录入":frTime=mes.record[i].feedbackreply.frTime;
                var frContent="";
                mes.record[i].feedbackreply.frContent==null?frContent="未录入":frContent=mes.record[i].feedbackreply.frContent;
                var fContent="";
                mes.record[i].fContent==null? fContent="未录入": fContent=mes.record[i].fContent;
                var fImagepath="";
                mes.record[i].fImagepath==null?fImagepath="未录入":fImagepath=mes.record[i].fImagepath;
                yeslist[i]=[fTitle,backtype,sldw,fTime,frTime,frContent,fContent,fImagepath];

            }
            getyesitem(yeslist);}
            hiden(loadmask);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function getyesitem(yesdata){
    var yeslist=document.getElementById("yeslist");
    var str="";
    for(var i=0;i<yesdata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showyes(this)'>"+yesdata[i][0]+"</a></li>"
    }
    yeslist.innerHTML=str;
}

//下一页
function yesgodown() {
    if(yesnowcount<yestotalpage){
        yesnowcount+=1;
        getyeslist();
    }else {
        return;
    }
}
//上一页
function yesgoup() {
    if(yesnowcount==0){
        return
    }else{
        nonowcount-=1;
        getyeslist();
    }

}

/*未解决*/


var nopage=false;
function show_hidenno(t) {
    if(nopage==false){
        document.getElementById("nopage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        nopage=true;
    }else {
        document.getElementById("nopage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        nopage=false;
    }
}






var nolist=[];
var nototalpage=1;
var nonowcount=0;
nogodown();
//点击查看党员详情
function showno(t){
    var noitem=parseInt(t.id.substring(2));
    var nomask=document.getElementById("nomask");

    var str="";
    str+="<div class='dycard'><table cellpadding='0' cellspacing='0'><tr><td>反馈标题：</td><td>";
    str+=nolist[noitem][0]+"</td></tr><tr><td>反馈类型：</td><td>";
    str+=nolist[noitem][1]+"</td></tr><tr><td>受理单位：</td><td>";
    str+=nolist[noitem][2]+"</td></tr><tr><td>提交时间：</td> <td>";
    str+=nolist[noitem][3].substring(0,10)+" </td></tr><tr><td>反馈内容：</td><td>";
    str+=nolist[noitem][4]+" </td></tr><tr><td>反馈图片：</td><td>";
    if(nolist[noitem][5]=="未录入"){
        str+="无</td></tr></table></div>";
    }else {
        var imgs=nolist[noitem][5].split(",")
        str+="</td></tr></table>"
        for(var i=0;i<imgs.length-1;i++){
            str+="<img style='position: relative;width: 100%;border-radius: 0.2rem;' src='http://47.105.118.98/jdpt/HJResourse/Feedback/"+imgs[i]+"'/>"
        }
    }

    nomask.innerHTML=str;
    showmask(nomask);
}

function nogojumppage() {
    dynowcount=document.getElementById("notopage").value;
    getnolist();
}

function getnolist() {
    showmask(loadmask);
    var userId=sessionStorage.getItem("userId");
    var year=document.getElementById("getyearno").value;
    $.ajax({
        url:'/jdpt/WeichuliSearch/'+userId+"/"+year+"/"+nonowcount+"/10",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            console.log(mes);
            //总页数
            if(mes.total==0){
                document.getElementById("nolist").innerHTML="<img  style='z-index: 10000;position: relative;width: 100%' src='/jdpt/static/img/null.png'/>"

            }else {
            document.getElementById("nolist").innerHTML="";
            nolist.length=0;
            nototalpage=mes.total;
            //当前页
            nonowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("no_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var nopagestr="";
            for(var i=1;i<=mes.total;i++){
                nopagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("notopage").innerHTML=nopagestr;
            for(var i=0;i<mes.record.length;i++){

                var fTitle="";
                mes.record[i].fTitle==null? fTitle="未录入": fTitle=mes.record[i].fTitle;
                var backtype="";
                mes.record[i].backtype.bType==null?backtype="未录入":backtype=mes.record[i].backtype.bType;
                var sldw="";
                if(mes.record[i].department==null||mes.record[i].zhen!=null){
                    sldw=mes.record[i].zhen.zName;
                }else if(mes.record[i].department!=null||mes.record[i].zhen==null){
                    sldw=mes.record[i].department.dName;
                }else {
                    sldw="未录入";
                }
                var fTime="";
                mes.record[i].fTime==null?fTime="未录入":fTime=mes.record[i].fTime;
                var fContent="";
                mes.record[i].fContent==null? fContent="未录入": fContent=mes.record[i].fContent;
                var fImagepath="";
                mes.record[i].fImagepath==null?fImagepath="未录入":fImagepath=mes.record[i].fImagepath;
                nolist[i]=[fTitle,backtype,sldw,fTime,fContent,fImagepath];

            }

            getnoitem(nolist);}
            hiden(loadmask);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function getnoitem(nodata){
    var nolist=document.getElementById("nolist");
    var str="";
    for(var i=0;i<nodata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showno(this)'>"+nodata[i][0]+"</a></li>"
    }
    nolist.innerHTML=str;
}

//下一页
function nogodown() {
    if(nonowcount<nototalpage){
        nonowcount+=1;
        getnolist();
    }else {
        return;
    }
}
//上一页
function nogoup() {
    if(nonowcount==0){
        return
    }else{
        nonowcount-=1;
        getnolist();
    }

}

