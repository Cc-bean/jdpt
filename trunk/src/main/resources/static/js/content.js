function zfoptions(){
    var str="";
    var nowdata=new Date();
    var year=nowdata.getFullYear();
    for(var i=year;i>2015;i--){
        str+="<option value='"+i+"'>"+i+"年</option>";
    }
    return str;
}
$("#getzfoptions").innerHTML=zfoptions();




/*党员*/
var dylist=[];
var dytotalpage=1;
var dynowcount=0;
dygodown();
//点击查看党员详情
function showdyinfo(t){
    var dyitem=parseInt(t.id.substring(2));
    var dymask=document.getElementById("dymask");
    //alert(dylist[dyitem][0]);
    var str="";
    str+="<div id='dycard' class='dangyuan'><table cellpadding='0' cellspacing='0'><tr><td>姓名：</td><td>";
    str+=dylist[dyitem][0]+"</td></tr><tr><td>姓别：</td><td>";
    str+=dylist[dyitem][1]+"</td></tr><tr><td>民族：</td><td>";
    str+=dylist[dyitem][2]+"族</td></tr><tr><td>籍贯：</td><td>";
    str+=dylist[dyitem][3]+"</td></tr><tr><td>入党时间：</td> <td>";
    str+=dylist[dyitem][4].substring(0,10)+" </td></tr><tr><td>发展时间：</td><td>";
    str+=dylist[dyitem][5].substring(0,10)+"</td></tr><tr><td>文化程度：</td><td>";
    str+=dylist[dyitem][6]+"</td></tr><tr><td>工作单位：</td><td>";
    str+=dylist[dyitem][7]+"</td></tr><tr><td>职务：</td><td>";
    str+=dylist[dyitem][8]+"</td></tr><tr><td>党员详细：</td><td>";
    str+=dylist[dyitem][9]+"</td></tr></table></div>";
    dymask.innerHTML=str;
    showmask(dymask);
}


var dypage=false;
function show_hidendy(t) {
    if(dypage==false){
        document.getElementById("dypage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        dypage=true;
    }else {
        document.getElementById("dypage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        dypage=false;
    }
}



//通过姓名查找党员

function dysearch() {
    var dyname=document.getElementById("searchdyname").value;
    var vId=sessionStorage.getItem("userVillageid");
    $.ajax({
        url:'http://localhost:8088/partyMembersByName/'+dyname+"/"+vId,
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            //console.log(mes);
            //document.getElementById("dylist").innerHTML="";
           // console.log( mes.partymemberinformationAndYonghuListByName[0].job.jName);
            dylist.length=0;
            for(var i=0;i<mes.partymemberinformationAndYonghuListByName.length;i++){
                var dyName="";
                mes.partymemberinformationAndYonghuListByName[i].job==null? jobName="未录入": jobName=mes.partymemberinformationAndYonghuListByName[i].job.jName;
                var dysex="";
                var dynation="";
                var dyjiguan="";
                var dyrdtime=""
                mes.partymemberinformationAndYonghuListByName[i].pmiJointime==null?dyrdtime="未录入":dyrdtime=mes.partymemberinformationAndYonghuListByName[i].pmiJointime.substring(0,9);;
                var dyfztime="";
                mes.partymemberinformationAndYonghuListByName.pmJoined==null?dyfztime="未录入":dyfztime=mes.partymemberinformationAndYonghuListByName[i].pmJoined.substring(0,9);
                var dywenhua="";
                var dyjobunit="";
                var jobName="";
                mes.partymemberinformationAndYonghuListByName.job==null? jobName="未录入": jobName=mes.partymemberinformationAndYonghuListByName.job.jName;
                var dyxuangxi="";
                //姓名，性别，民族，籍贯，入党时间，发展时间，文化程度，工作单位，职位，党员详细
                dylist[i]=[mes.partymemberinformationAndYonghuListByName[i].yonghu.userName,mes.partymemberinformationAndYonghuListByName[i].yonghu.userSex,mes.partymemberinformationAndYonghuListByName[i].nation,mes.partymemberinformationAndYonghuListByName[i].pmJiguan,dyrdtime,dyfztime,mes.partymemberinformationAndYonghuListByName[i].pmiDegreeofeducation,mes.partymemberinformationAndYonghuListByName[i].pmiInauguralunit,jobName,mes.partymemberinformationAndYonghuListByName[i].pmiDetails];

            }
            //得到党员列表
           // console.log(dylist[0]);
            getdyitem(dylist);
        },
        error:function(xhr,type,errorThrown){
        }
    });

}
function godyjumppage() {
    dynowcount=document.getElementById("dytopage").value;
    //alert(dynowcount);
    getdylist();
}

function getdylist() {
    var vId=sessionStorage.getItem("userVillageid");
    $.ajax({
        url:'http://localhost:8088/partyMembersPage/'+dynowcount+"/20/"+vId,
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
           // console.log(mes);
            //总页数
            document.getElementById("dylist").innerHTML=null;
            dylist.length=0;
            dytotalpage=mes.total;
            //当前页
            dynowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("dy_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var dypagestr="";
            for(var i=1;i<=mes.total;i++){
                dypagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("dytopage").innerHTML=dypagestr;

            for(var i=0;i<mes.record.length;i++){
                var dyName="";
                mes.record[i].job==null? jobName="未录入": jobName=mes.record[i].job.jName;
                var dysex="";
                var dynation="";
                var dyjiguan="";
                var dyrdtime=""
                mes.record[i].pmiJointime==null?dyrdtime="未录入":dyrdtime=mes.record[i].pmiJointime.substring(0,9);;
                var dyfztime="";
                mes.record[i].pmJoined==null?dyfztime="未录入":dyfztime=mes.record[i].pmJoined.substring(0,9);
                var dywenhua="";
                var dyjobunit="";
                var jobName="";
                mes.record[i].job==null? jobName="未录入": jobName=mes.record[i].job.jName;
                var dyxuangxi="";
                //姓名，性别，民族，籍贯，入党时间，发展时间，文化程度，工作单位，职位，党员详细
                dylist[i]=[mes.record[i].yonghu.userName,mes.record[i].yonghu.userSex,mes.record[i].nation,mes.record[i].pmJiguan,dyrdtime,dyfztime,mes.record[i].pmiDegreeofeducation,mes.record[i].pmiInauguralunit,jobName,mes.record[i].pmiDetails];

            }
            //console.log(dylist[0]);
            //得到党员列表
            getdyitem(dylist);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function getdyitem(dydata){
    var dylist=document.getElementById("dylist");
    var str="";
    for(var i=0;i<dydata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showdyinfo(this)'>"+dydata[i][0]+"</a></li>"
    }
    dylist.innerHTML=str;
}

//下一页
function dygodown() {
    if(dynowcount<dytotalpage){
        dynowcount+=1;
        getdylist();
    }else {
        return;
    }
}
//上一页
function dygoup() {
    if(dynowcount==0){
        return
    }else{
        dynowcount-=1;
       // alert();
        getdylist();
    }

}



/*教育咨询*/


var jypage=false;
function show_hidenjy(t) {
    if(jypage==false){
        document.getElementById("jypage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        jypage=true;
    }else {
        document.getElementById("jypage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        jypage=false;
    }
}


var jylist=[];
var jytotalpage=1;
var jynowcount=0;
jygodown();

//跳转到指定页
function gojyjumppage() {
    dynowcount=document.getElementById("jiaoyutopage").value;
    //alert(dynowcount);
    getjylist();
}

//得到教育文件列表
function getjylist() {
    $.ajax({
        url:'http://localhost:8088/queryAll/'+jynowcount+"/20",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            console.log(mes);
            //总页数
          /* document.getElementById("jylist").innerHTML=null;
            jylist.length=0;
            jytotalpage=mes.total;
            //当前页
            jynowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("jy_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var jypagestr="";
            for(var i=1;i<=mes.total;i++){
                jypagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("jytopage").innerHTML=jypagestr;

            for(var i=0;i<mes.record.length;i++){
                var dyName="";
                mes.record[i].job==null? jobName="未录入": jobName=mes.record[i].job.jName;
                var dysex="";
                var dynation="";
                var dyjiguan="";
                var dyrdtime=""
                mes.record[i].pmiJointime==null?dyrdtime="未录入":dyrdtime=mes.record[i].pmiJointime.substring(0,9);;
                var dyfztime="";
                mes.record[i].pmJoined==null?dyfztime="未录入":dyfztime=mes.record[i].pmJoined.substring(0,9);
                var dywenhua="";
                var dyjobunit="";
                var jobName="";
                mes.record[i].job==null? jobName="未录入": jobName=mes.record[i].job.jName;
                var dyxuangxi="";
                //姓名，性别，民族，籍贯，入党时间，发展时间，文化程度，工作单位，职位，党员详细
                jylist[i]=[mes.record[i].yonghu.userName,mes.record[i].yonghu.userSex,mes.record[i].nation,mes.record[i].pmJiguan,dyrdtime,dyfztime,mes.record[i].pmiDegreeofeducation,mes.record[i].pmiInauguralunit,jobName,mes.record[i].pmiDetails];

            }
            //console.log(dylist[0]);
            getjyitem(jylist);*/

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

//得到教育列表
function getjyitem(jydata){
    var jylist=document.getElementById("jylist");
    var str="";
    for(var i=0;i<dydata.length;i++){
        str+="<li class='table-view-cell'>"+"<a class='navigate-right' id='jy"+i+"'"+" onclick='gojiaoyu(this)'>"+jydata[i][0]+"</a></li>"
    }
    jylist.innerHTML=str;
}

//下一页
function jygodown() {
    if(jynowcount<jytotalpage){
        jynowcount+=1;
        getjylist();
    }else {
        return;
    }
}
//上一页
function jygoup() {
    if(dynowcount==0){
        return
    }else{
        //alert(dynowcount);
        getjylist();
    }

}



/*组织发展*/


var zfpage=false;
function show_hidenzf(t) {
    if(dypage==false){
        document.getElementById("zfpage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        zfpage=true;
    }else {
        document.getElementById("zfpage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        zfpage=false;
    }
}


var nowdata=new Date();
var nowzyyear=nowdata.getFullYear();
var zftotalpage=1;
var zfnowpage=0;
var zfkey=1;
var jjfzVillage=userInfo.getItem("userVillageid");
//积极分子
var url1="http://localhost:8088/pageFindJijifenziByJjfzVillageandJjfzYear/";
//发展对象
var url2="http://localhost:8088/pageFindFazhanduixiangByFzdxYearandFzdxVillage/";
//预备党员
var url3="http://localhost:8088/pageFondYvbeidangyuanByYbdyYearandYbdyVillage/";
//党员转正
var url4="http://localhost:8088/pageFindDangyuanzhuanzhengByDyzzYearanDdyzzVillage/";
//变更情况
var url5="http://localhost:8088/pageFindQingkuangbiangengByQkbgYearandQkbgZu/";

zfgodown();
//上一页
function zfgoup() {
    if(zfnowpage<=1){
        return
    }else {
        zfnowpage-=1;
        zfkey= $("#zfkey").val();
        nowzyyear= $("#getzfoptions").val();
        switch (zfkey) {
            case 1:
                var url=url1+jjfzVillage+"/"+nowzyyear+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 2:
                var url=url2+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 3:
                var url=url3+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 4:
                var url=url4+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 5:
                var url=url5+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
        }
    }


}
//下一页
function zfgodown() {
    if(zfnowpage<zftotalpage){
        zfnowpage+=1;
        //alert(zfnowpage);
        zfkey= $("#zfkey").val();
        //zfkey=1;getzfoptions
        nowzyyear= $("#getzfoptions").val();
        //nowzyyear=2019;
        // alert(zfkey+"/"+nowzyyear);
        switch (zfkey) {
            case 1:
                var url=url1+jjfzVillage+"/"+nowzyyear+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 2:
                var url=url2+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 3:
                var url=url3+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 4:
                var url=url4+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
            case 5:
                var url=url5+nowzyyear+"/"+jjfzVillage+"/"+zfnowpage+"/20";
                getzflist(url);break;
        }
    }else {
        return
    }
}


function getzflist(zfurl) {
    alert("ender");
    $.ajax({
        url:zfurl,
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){

            console.log(mes);
            //总页数
            document.getElementById("xjlist").innerHTML="";
            xjlist.length=0;
            xjtotalpage=mes.total;
            //当前页
            xjnowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("xj_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var xjpagestr="";
            for(var i=1;i<=mes.total;i++){
                xjpagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("xjtopage").innerHTML=xjpagestr;

            for(var i=0;i<mes.OperationManagements.length;i++){
                var xjName="";
                mes.OperationManagements[i].om_Name==null? jobName="未录入": xjName=mes.OperationManagements[i].om_Name;
                var xjbianhao="";
                mes.OperationManagements[i].om_TenderingMaterial==null? xjbianhao="未录入": xjbianhao=mes.OperationManagements[i].om_TenderingMaterial;
                var xjshishifang="";
                mes.OperationManagements[i].om_ImplementingParty==null? xjshishifang="未录入": xjshishifang=mes.OperationManagements[i].om_ImplementingParty;
                var xjjianligang="";
                mes.OperationManagements[i].om_FollowUpManagement==null? xjjianligang="未录入": xjjianligang=mes.OperationManagements[i].om_FollowUpManagement;
                var xjyanshoufang=""
                mes.OperationManagements[i].om_Acceptanceparty==null? xjyanshoufang="未录入": xjyanshoufang=mes.OperationManagements[i].om_Acceptanceparty;
                var xjiszhaobiao="";
                mes.OperationManagements[i].om_ImplementThePlan==null? xjiszhaobiao="未录入": xjiszhaobiao=mes.OperationManagements[i].om_ImplementThePlan;
                var xjislixiang="";
                mes.OperationManagements[i].om_SourceOfFunds==null? xjislixiang="未录入": xjislixiang=mes.OperationManagements[i].om_SourceOfFunds;
                var xjquyu="";
                mes.OperationManagements[i].names==null? xjquyu="未录入": xjquyu=mes.OperationManagements[i].names.regionName+mes.OperationManagements[i].names.zhenName+mes.OperationManagements[i].names.villageName;
                var xjzhifu="";
                mes.OperationManagements[i].om_DivisionOfResponsibility==null? xjzhifu="未录入": xjzhifu=mes.OperationManagements[i].om_DivisionOfResponsibility;
                var xjbeizhu="";
                mes.OperationManagements[i].om_Type==null? xjbeizhu="未录入": xjbeizhu=mes.OperationManagements[i].om_Type;

                xjlist[i]=[xjName,xjbianhao,xjshishifang,xjjianligang,xjyanshoufang,xjiszhaobiao,xjislixiang,xjquyu,xjzhifu,xjbeizhu];

            }
            getxjitem(xjlist);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}


function showzfInfo(t){
    var zuzhimask=document.getElementById("zuzhimask");
    showmask(zuzhimask);
}











/*组织活动*/


/*资源*/
/*资产*/
/*资金*/
/*项目建设信息*/


var xjpage=false;
function show_hidenxj(t) {
    if(xjpage==false){
        document.getElementById("xjpage").style.width="100%";
        t.style.transform="rotate(180deg)";
        t.style.otransform="rotate(180deg)";
        t.style.mstransform="rotate(180deg)";
        t.style.moztransform="rotate(180deg)";
        t.style.webkittransform="rotate(180deg)";
        xjpage=true;
    }else {
        document.getElementById("xjpage").style.width="2rem";
        t.style.transform="rotate(0deg)";
        t.style.otransform="rotate(0deg)";
        t.style.mstransform="rotate(0deg)";
        t.style.moztransform="rotate(0deg)";
        t.style.webkittransform="rotate(0deg)";
        xjpage=false;
    }
}





var xjlist=[];
var xjtotalpage=1;
var xjnowcount=0;
xjgodown();


//点击查看党员详情
function showprojectInfo(t){
    var xjitem=parseInt(t.id.substring(2));
    var xjmask=document.getElementById("xjmask");
    var str="";
    str+="<div id='xjcard' class='dangyuan'><table cellpadding='0' cellspacing='0'><tr><td>项目名称：</td><td>";
    str+=xjlist[xjitem][0]+"</td></tr><tr><td>项目编号：</td><td>";
    str+=xjlist[xjitem][1]+"</td></tr><tr><td>实施方：</td><td>";
    str+=xjlist[xjitem][2]+"</td></tr><tr><td>监理方：</td><td>";
    str+=xjlist[xjitem][3]+"</td></tr><tr><td>验收方：</td> <td>";
    str+=xjlist[xjitem][4]+" </td></tr><tr><td>是否招标：</td><td>";
    str+=xjlist[xjitem][5]+"</td></tr><tr><td>是否立项：</td><td>";
    str+=xjlist[xjitem][6]+"</td></tr><tr><td>所属区域：</td><td>";
    str+=xjlist[xjitem][7]+"</td></tr><tr><td>支付情况：</td><td>";
    str+=xjlist[xjitem][8]+"</td></tr><tr><td>备注：</td><td>";
    str+=xjlist[xjitem][9]+"</td></tr></table></div>";
    xjmask.innerHTML=str;
    showmask(xjmask);
}

//通过姓名查找党员

function xjsearch() {
    var xjname=document.getElementById("searchxjname").value;
    $.ajax({
        url:'http://localhost:8088/queryOperationManagement/'+xjname+"/1/1000",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            //console.log(mes);
            document.getElementById("xjlist").innerHTML="";
            xjlist.length=0;
            for(var i=0;i<mes.OperationManagement.length;i++){
                var xjName="";
                mes.OperationManagement[i].om_Name==null? jobName="未录入": xjName=mes.OperationManagement[i].om_Name;
                var xjbianhao="";
                mes.OperationManagement[i].om_TenderingMaterial==null? xjbianhao="未录入": xjbianhao=mes.OperationManagement[i].om_TenderingMaterial;
                var xjshishifang="";
                mes.OperationManagement[i].om_ImplementingParty==null? xjshishifang="未录入": xjshishifang=mes.OperationManagement[i].om_ImplementingParty;
                var xjjianligang="";
                mes.OperationManagement[i].om_FollowUpManagement==null? xjjianligang="未录入": xjjianligang=mes.OperationManagement[i].om_FollowUpManagement;
                var xjyanshoufang=""
                mes.OperationManagement[i].om_Acceptanceparty==null? xjyanshoufang="未录入": xjyanshoufang=mes.OperationManagement[i].om_Acceptanceparty;
                var xjiszhaobiao="";
                mes.OperationManagement[i].om_ImplementThePlan==null? xjiszhaobiao="未录入": xjiszhaobiao=mes.OperationManagement[i].om_ImplementThePlan;
                var xjislixiang="";
                mes.OperationManagement[i].om_SourceOfFunds==null? xjislixiang="未录入": xjislixiang=mes.OperationManagement[i].om_SourceOfFunds;
                var xjquyu="";
                mes.OperationManagement[i].names==null? xjquyu="未录入": xjquyu=mes.OperationManagement[i].names.regionName+mes.OperationManagement[i].names.zhenName+mes.OperationManagement[i].names.villageName;
                var xjzhifu="";
                mes.OperationManagement[i].om_DivisionOfResponsibility==null? xjzhifu="未录入": xjzhifu=mes.OperationManagement[i].om_DivisionOfResponsibility;
                var xjbeizhu="";
                mes.OperationManagement[i].om_Type==null? xjbeizhu="未录入": xjbeizhu=mes.OperationManagement[i].om_Type;

                xjlist[i]=[xjName,xjbianhao,xjshishifang,xjjianligang,xjyanshoufang,xjiszhaobiao,xjislixiang,xjquyu,xjzhifu,xjbeizhu];

            }
            getxjitem(xjlist);

        },
        error:function(xhr,type,errorThrown){
        }
    });

}
function goxjjumppage() {
    xjnowcount=document.getElementById("xjtopage").value;
    //alert(dynowcount);
    getxjlist();
}

function getxjlist() {
    $.ajax({
        url:'http://localhost:8088/queryOperationManagements/'+xjnowcount+"/20",
        dataType:"JSON",//服务器返回json格式数据
        type:'GET',//HTTP请求类型
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        success:function(mes){
            //console.log(mes);
            //总页数
           document.getElementById("xjlist").innerHTML="";
            xjlist.length=0;
            xjtotalpage=mes.total;
            //当前页
            xjnowcount=mes.nowPage;
            //填写当前页共多少页
            document.getElementById("xj_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
            //得到selectpage的页码选择
            var xjpagestr="";
            for(var i=1;i<=mes.total;i++){
                xjpagestr+="<option value='"+i+"'>"+i+"</option>";
            }
            document.getElementById("xjtopage").innerHTML=xjpagestr;

            for(var i=0;i<mes.OperationManagements.length;i++){
                var xjName="";
                mes.OperationManagements[i].om_Name==null? jobName="未录入": xjName=mes.OperationManagements[i].om_Name;
                var xjbianhao="";
                mes.OperationManagements[i].om_TenderingMaterial==null? xjbianhao="未录入": xjbianhao=mes.OperationManagements[i].om_TenderingMaterial;
                var xjshishifang="";
                mes.OperationManagements[i].om_ImplementingParty==null? xjshishifang="未录入": xjshishifang=mes.OperationManagements[i].om_ImplementingParty;
                var xjjianligang="";
                mes.OperationManagements[i].om_FollowUpManagement==null? xjjianligang="未录入": xjjianligang=mes.OperationManagements[i].om_FollowUpManagement;
                var xjyanshoufang=""
                mes.OperationManagements[i].om_Acceptanceparty==null? xjyanshoufang="未录入": xjyanshoufang=mes.OperationManagements[i].om_Acceptanceparty;
                var xjiszhaobiao="";
                mes.OperationManagements[i].om_ImplementThePlan==null? xjiszhaobiao="未录入": xjiszhaobiao=mes.OperationManagements[i].om_ImplementThePlan;
                var xjislixiang="";
                mes.OperationManagements[i].om_SourceOfFunds==null? xjislixiang="未录入": xjislixiang=mes.OperationManagements[i].om_SourceOfFunds;
                var xjquyu="";
                mes.OperationManagements[i].names==null? xjquyu="未录入": xjquyu=mes.OperationManagements[i].names.regionName+mes.OperationManagements[i].names.zhenName+mes.OperationManagements[i].names.villageName;
                var xjzhifu="";
                mes.OperationManagements[i].om_DivisionOfResponsibility==null? xjzhifu="未录入": xjzhifu=mes.OperationManagements[i].om_DivisionOfResponsibility;
                var xjbeizhu="";
                mes.OperationManagements[i].om_Type==null? xjbeizhu="未录入": xjbeizhu=mes.OperationManagements[i].om_Type;

                xjlist[i]=[xjName,xjbianhao,xjshishifang,xjjianligang,xjyanshoufang,xjiszhaobiao,xjislixiang,xjquyu,xjzhifu,xjbeizhu];

            }
            getxjitem(xjlist);

        },
        error:function(xhr,type,errorThrown){
            //异常处理

        }
    });
}

function getxjitem(dydata){
    var xjlist=document.getElementById("xjlist");
    var str="";
    for(var i=0;i<dydata.length;i++){
        str+="<li class='table-view-cell'>"+"<a id='xj"+i+"'"+" onclick='showprojectInfo(this)'>"+dydata[i][0]+"</a></li>"
    }
    xjlist.innerHTML=str;
}

//下一页
function xjgodown() {
    if(xjnowcount<xjtotalpage){
        xjnowcount+=1;
        getxjlist();
    }else {
        return;
    }
}
//上一页
function xjgoup() {
    if(xjnowcount==0){
        return
    }else{
        xjnowcount-=1;
        getxjlist();
    }

}







/*政策学习*/
/*法律教育*/