
/!*会议*!/
var huiyipage=false;
function show_hidenhuiyi(t) {
    if(huiyipage==false){
        document.getElementById("huiyipage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        huiyipage=true;
    }else {
        document.getElementById("huiyipage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        huiyipage=false;
    }
}






var huiyilist=[];
var huiyitotalpage=1;
var huiyinowcount=0;
huiyigodown();
//点击查看党员详情
function showhuiyi(t){
    var huiyiitem=parseInt(t.id.substring(2));
    var huiyimask=document.getElementById("huiyimask");

    var str="";
    str+="<div id='dycard' class='dycard'><table cellpadding='0' cellspacing='0'><tr><td>姓名：</td><td>";
    str+=huiyilist[huiyiitem][0]+"</td></tr><tr><td>姓别：</td><td>";
    str+=huiyilist[huiyiitem][1]+"</td></tr><tr><td>联系方式：</td><td>";
    str+=huiyilist[huiyiitem][2]+"</td></tr><tr><td>职位：</td><td>";
    str+=huiyilist[huiyiitem][3]+"</td></tr><tr><td>待遇：</td> <td>";
    str+=huiyilist[huiyiitem][4]+" </td></tr><tr><td>职责明细：</td><td>";
    str+=huiyilist[huiyiitem][5]+"</td></tr></table></div>";
    huiyimask.innerHTML=str;
    showmask(huiyimask);
}




function huiyigojumppage() {
    dynowcount=document.getElementById("huiyitopage").value;
    gethuiyilist();
}

function gethuiyilist() {
    var vId=sessionStorage.getItem("userVillageid");
    $.ajax({
        url:'http://localhost:8088/FindHuiyiByCunId/'+vId+"/"+huiyinowcount+"/10",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            console.log(mes);
            //总页数
            document.getElementById("huiyilist").innerHTML="";
            huiyilist.length=0;
            huiyitotalpage=mes.total;
            //当前页
            huiyinowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("huiyi_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var huiyipagestr="";
            for(var i=1;i<=mes.total;i++){
                huiyipagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("huiyitopage").innerHTML=huiyipagestr;

            for(var i=0;i<mes.record.length;i++){
                var name="";
                mes.record[i].vcName==null? name="未录入": name=mes.record[i].vcName;
                var xingbie="";
                mes.record[i].vcSex==null?xingbie="未录入":xingbie=mes.record[i].vcSex;
                var dianhua="";
                mes.record[i].vcPhone==null?dianhua="未录入":dianhua=mes.record[i].vcPhone;
                var zhiwei="";
                mes.record[i].job==null?zhiwei="未录入":zhiwei=mes.record[i].job.jNmae;
                var daiyu=""
                mes.record[i].vcGongzi==null?daiyu="未录入":daiyu=mes.record[i].vcGongzi;
                var zhizemingxi="";
                mes.record[i].vcZhize==null?zhizemingxi="未录入":zhizemingxi=mes.record[i].vcZhize;
                huiyilist[i]=[name,xingbie,dianhua,zhiwei,daiyu,zhizemingxi];

            }
            getdyitem(huiyilist);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function getdyitem(huiyidata){
    var huiyilist=document.getElementById("huiyilist");
    var str="";
    for(var i=0;i<huiyidata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showhuiyi(this)'>"+huiyidata[i][0]+"</a></li>"
    }
    huiyilist.innerHTML=str;
}

//下一页
function huiyigodown() {
    if(huiyinowcount<huiyitotalpage){
        huiyinowcount+=1;
        gethuiyilist();
    }else {
        return;
    }
}
//上一页
function huiyigoup() {
    if(huiyinowcount==0){
        return
    }else{

        gethuiyilist();
    }

}




/!*活动*!/


var huodongpage=false;
function show_hidenhuodong(t) {
    if(huodongpage==false){
        document.getElementById("huodongpage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        huodongpage=true;
    }else {
        document.getElementById("huodongpage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        huodongpage=false;
    }
}







var huodonglist=[];
var huodongtotalpage=1;
var huodongnowcount=0;
huodonggodown();
//点击查看党员详情
function showhuodong(t){
    var huodongitem=parseInt(t.id.substring(2));
    var huodongmask=document.getElementById("huodongmask");

    var str="";
    str+="<div class='dycard'><table cellpadding='0' cellspacing='0'><tr><td>姓名：</td><td>";
    str+=huodonglist[huodongitem][0]+"</td></tr><tr><td>姓别：</td><td>";
    str+=huodonglist[huodongitem][1]+"</td></tr><tr><td>联系方式：</td><td>";
    str+=huodonglist[huodongitem][2]+"</td></tr><tr><td>职位：</td><td>";
    str+=huodonglist[huodongitem][3]+"</td></tr><tr><td>待遇：</td> <td>";
    str+=huodonglist[huodongitem][4]+" </td></tr><tr><td>职责明细：</td><td>";
    str+=huodonglist[huodongitem][5]+"</td></tr></table></div>";
    huodongmask.innerHTML=str;
    showmask(huodongmask);
}




function huodonggojumppage() {
    huodongnowcount=document.getElementById("huodongtopage").value;
    gethuodonglist();
}

function gethuodonglist() {
    var vId=sessionStorage.getItem("userVillageid");
    $.ajax({
        url:'http://localhost:8088/PageFindCunHuoDong/'+vId+"/"+huodongnowcount+"/10",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            console.log(mes);
            //总页数
            document.getElementById("huodonglist").innerHTML="";
            huodonglist.length=0;
            huodongtotalpage=mes.total;
            //当前页
            huodongnowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("huodong_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var huodongpagestr="";
            for(var i=1;i<=mes.total;i++){
                huodongpagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("huodongtopage").innerHTML=huodongpagestr;

            for(var i=0;i<mes.record.length;i++){
                var name="";
                mes.record[i].vcName==null? name="未录入": name=mes.record[i].vcName;
                var xingbie="";
                mes.record[i].vcSex==null?xingbie="未录入":xingbie=mes.record[i].vcSex;
                var dianhua="";
                mes.record[i].vcPhone==null?dianhua="未录入":dianhua=mes.record[i].vcPhone;
                var zhiwei="";
                mes.record[i].job==null?zhiwei="未录入":zhiwei=mes.record[i].job.jNmae;
                var daiyu=""
                mes.record[i].vcGongzi==null?daiyu="未录入":daiyu=mes.record[i].vcGongzi;
                var zhizemingxi="";
                mes.record[i].vcZhize==null?zhizemingxi="未录入":zhizemingxi=mes.record[i].vcZhize;
                huodonglist[i]=[name,xingbie,dianhua,zhiwei,daiyu,zhizemingxi];

            }
            gethuodongitem(huodonglist);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function gethuodongitem(huiyidata){
    var huiyilist=document.getElementById("huiyilist");
    var str="";
    for(var i=0;i<huiyidata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showhuodong(this)'>"+huiyidata[i][0]+"</a></li>"
    }
    huodonglist.innerHTML=str;
}

//下一页
function huodonggodown() {
    if(huodongnowcount<huodongtotalpage){
        huodongnowcount+=1;
        gethuodonglist();
    }else {
        return;
    }
}
//上一页
function huodonggoup() {
    if(huodongnowcount==0){
        return
    }else{

        gethuodonglist();
    }

}




/*迁入*/






var qianrupage=false;
function show_hidenqianru(t) {
    if(qianrupage==false){
        document.getElementById("qianrupage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        qianrupage=true;
    }else {
        document.getElementById("qianrupage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        qianrupage=false;
    }
}







var qianrulist=[];
var qianrutotalpage=1;
var qianrunowcount=0;
qianrugodown();
//点击查看党员详情
function showhuodong(t){
    var qianruitem=parseInt(t.id.substring(2));
    var qianrumask=document.getElementById("qianrumask");

    var str="";
    str+="<div class='dycard'><table cellpadding='0' cellspacing='0'><tr><td>姓名：</td><td>";
    str+=qianrulist[qianruitem][0]+"</td></tr><tr><td>姓别：</td><td>";
    str+=qianrulist[qianruitem][1]+"</td></tr><tr><td>联系方式：</td><td>";
    str+=qianrulist[qianruitem][2]+"</td></tr><tr><td>职位：</td><td>";
    str+=qianrulist[qianruitem][3]+"</td></tr><tr><td>待遇：</td> <td>";
    str+=qianrulist[qianruitem][4]+" </td></tr><tr><td>职责明细：</td><td>";
    str+=qianrulist[qianruitem][5]+"</td></tr></table></div>";
    qianrumask.innerHTML=str;
    showmask(qianrumask);
}




function qianrugojumppage() {
    qianrunowcount=document.getElementById("qianrutopage").value;
    getqianrulist();
}

function getqianrulist() {
    var vId=sessionStorage.getItem("userVillageid");
    $.ajax({
        url:'http://localhost:8088/FindByCunIdLeixing/'+vId+"/1/"+qianrunowcount+"/10",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            console.log(mes);
            //总页数
            document.getElementById("qianrulist").innerHTML="";
            qianrulist.length=0;
            qianrutotalpage=mes.total;
            //当前页
            qianrunowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("qianru_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var qianrupagestr="";
            for(var i=1;i<=mes.total;i++){
                qianrupagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("qianrutopage").innerHTML=qianrupagestr;

            for(var i=0;i<mes.record.length;i++){
                var name="";
                mes.record[i].vcName==null? name="未录入": name=mes.record[i].vcName;
                var xingbie="";
                mes.record[i].vcSex==null?xingbie="未录入":xingbie=mes.record[i].vcSex;
                var dianhua="";
                mes.record[i].vcPhone==null?dianhua="未录入":dianhua=mes.record[i].vcPhone;
                var zhiwei="";
                mes.record[i].job==null?zhiwei="未录入":zhiwei=mes.record[i].job.jNmae;
                var daiyu=""
                mes.record[i].vcGongzi==null?daiyu="未录入":daiyu=mes.record[i].vcGongzi;
                var zhizemingxi="";
                mes.record[i].vcZhize==null?zhizemingxi="未录入":zhizemingxi=mes.record[i].vcZhize;
                dylist[i]=[name,xingbie,dianhua,zhiwei,daiyu,zhizemingxi];

            }
            getqianruitem(qianrulist);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function getqianruitem(huiyidata){
    var qianrulist=document.getElementById("qianrulist");
    var str="";
    for(var i=0;i<huiyidata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showqianru(this)'>"+huiyidata[i][0]+"</a></li>"
    }
    qianrulist.innerHTML=str;
}

//下一页
function qianrugodown() {
    if(qianrunowcount<qianrutotalpage){
        qianrunowcount+=1;
        getqianrulist();
    }else {
        return;
    }
}
//上一页
function qianrugoup() {
    if(qianrunowcount==0){
        return
    }else{

        getqianrulist();
    }

}



/*迁出*/




var qianchupage=false;
function show_hidenqianchu(t) {
    if(qianchupage==false){
        document.getElementById("qianchupage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        qianchupage=true;
    }else {
        document.getElementById("qianchupage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        qianchupage=false;
    }
}







var qianchulist=[];
var qianchutotalpage=1;
var qianchunowcount=0;
qianchugodown();
//点击查看党员详情
function showhuodong(t){
    var qianchuitem=parseInt(t.id.substring(2));
    var qianchumask=document.getElementById("qianchumask");

    var str="";
    str+="<div class='dycard'><table cellpadding='0' cellspacing='0'><tr><td>姓名：</td><td>";
    str+=qianchulist[qianchuitem][0]+"</td></tr><tr><td>姓别：</td><td>";
    str+=qianchulist[qianchulist][1]+"</td></tr><tr><td>联系方式：</td><td>";
    str+=qianchulist[qianchulist][2]+"</td></tr><tr><td>职位：</td><td>";
    str+=qianchulist[qianchulist][3]+"</td></tr><tr><td>待遇：</td> <td>";
    str+=qianchulist[qianchulist][4]+" </td></tr><tr><td>职责明细：</td><td>";
    str+=qianchulist[qianchulist][5]+"</td></tr></table></div>";
    qianchumask.innerHTML=str;
    showmask(qianchumask);
}




function qianchugojumppage() {
    qianchunowcount=document.getElementById("qianchutopage").value;
    getqianchulist();
}

function getqianchulist() {
    var vId=sessionStorage.getItem("userVillageid");
    $.ajax({
        url:'http://localhost:8088/FindByCunIdLeixing/'+vId+"/2/"+qianchunowcount+"/10",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            console.log(mes);
            //总页数
            document.getElementById("qianchulist").innerHTML="";
            qianchulist.length=0;
            qianchutotalpage=mes.total;
            //当前页
            qianchunowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("qianru_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var qianchupagestr="";
            for(var i=1;i<=mes.total;i++){
                qianchupagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("qianchutopage").innerHTML=qianchupagestr;

            for(var i=0;i<mes.record.length;i++){
                var name="";
                mes.record[i].vcName==null? name="未录入": name=mes.record[i].vcName;
                var xingbie="";
                mes.record[i].vcSex==null?xingbie="未录入":xingbie=mes.record[i].vcSex;
                var dianhua="";
                mes.record[i].vcPhone==null?dianhua="未录入":dianhua=mes.record[i].vcPhone;
                var zhiwei="";
                mes.record[i].job==null?zhiwei="未录入":zhiwei=mes.record[i].job.jNmae;
                var daiyu=""
                mes.record[i].vcGongzi==null?daiyu="未录入":daiyu=mes.record[i].vcGongzi;
                var zhizemingxi="";
                mes.record[i].vcZhize==null?zhizemingxi="未录入":zhizemingxi=mes.record[i].vcZhize;
                dylist[i]=[name,xingbie,dianhua,zhiwei,daiyu,zhizemingxi];

            }
            getqianchuitem(qianchulist);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function getqianchuitem(huiyidata){
    var qianchulist=document.getElementById("qianchulist");
    var str="";
    for(var i=0;i<huiyidata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showqianchu(this)'>"+huiyidata[i][0]+"</a></li>"
    }
    qianchulist.innerHTML=str;
}

//下一页
function qianchugodown() {
    if(qianchunowcount<qianchutotalpage){
        qianchunowcount+=1;
        getqianchulist();
    }else {
        return;
    }
}
//上一页
function qianchugoup() {
    if(qiancchunowcount==0){
        return
    }else{

        getqianchulist();
    }

}
