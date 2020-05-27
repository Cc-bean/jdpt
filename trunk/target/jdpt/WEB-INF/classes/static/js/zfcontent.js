var zfpage=false;
function show_hidenzf(t) {
    if(zfpage==false){
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
var zflist=[];
var zftotalpage=1;
var zfjjnowpage=0;
var zffznowpage=0;
var zfybnowpage=0;
var zfzznowpage=0;
var zfbgnowpage=0;
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


//上一页
function zfgoup() {
    zfkey= $("#zfkey").val();
    nowzyyear= $("#getzfoptions").val();
    switch (zfkey) {
        case 1:
            if(zfjjnowpage>1){
                zfjjnowpage-=1;
                var url=url1+jjfzVillage+"/"+nowzyyear+"/"+zfjjnowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
        case 2:
            if(zffznowpage>1){
                zffznowpage-=1;
                var url=url2+nowzyyear+"/"+jjfzVillage+"/"+zffznowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
        case 3:
            if(zfybnowpage>1){
                zfybnowpage-=1;
                var url=url3+nowzyyear+"/"+jjfzVillage+"/"+zfybnowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
        case 4:
            if(zfzznowpage>1){
                zfzznowpage-=1;
                var url=url4+nowzyyear+"/"+jjfzVillage+"/"+zfzznowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
        case 5:
            if(zfbgnowpage>1){
                zfbgnowpage-=1;
                var url=url5+nowzyyear+"/"+jjfzVillage+"/"+zfbgnowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
    }


}
//下一页
function zfgodown() {
    zfkey= $("#zfkey").val();
    nowzyyear= $("#getzfoptions").val();
    switch (zfkey) {
        case 1:
            if(zfjjnowpage<zftotalpage){
                zfjjnowpage+=1;
                var url=url1+jjfzVillage+"/"+nowzyyear+"/"+zfjjnowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
        case 2:
            if(zffznowpage<zftotalpage){
                zffznowpage+=1;
                var url=url2+nowzyyear+"/"+jjfzVillage+"/"+zffznowpage+"/10";
                getzflist(url);
            }else {
                return
            }
           break;
        case 3:
            if(zfybnowpage<zftotalpage){
                zfybnowpage+=1;
                var url=url3+nowzyyear+"/"+jjfzVillage+"/"+zfybnowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
        case 4:
            if(zfzznowpage<zftotalpage){
                zfzznowpage+=1;
                var url=url4+nowzyyear+"/"+jjfzVillage+"/"+zfzznowpage+"/10";
                getzflist(url);
            }else {
                return
            }
            break;
        case 5:
            if(zfbgnowpage<zftotalpage){
                zfbgnowpage+=1;
                var url=url5+nowzyyear+"/"+jjfzVillage+"/"+zfbgnowpage+"/10";
                getzflist(url);
            }else {
                return
            }
           break;
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
            console.log("组织发展");
            console.log(mes);
             document.getElementById("zflist").innerHTML="";
             zflist.length=0;
             zftotalpage=mes.total;
             //当前页
             zfnowcount=mes.nowPage;
             //填写当前页共多少页
             document.getElementById("zf_page_totals").innerHTML=mes.nowPage+"/"+mes.total;
             //得到selectpage的页码选择
             var zfpagestr="";
             for(var i=1;i<=mes.total;i++){
                 zfpagestr+="<option value='"+i+"'>"+i+"</option>";
             }
             document.getElementById("zftopage").innerHTML=zfpagestr;

             for(var i=0;i<mes.OperationManagements.length;i++){
                 /*var xjName="";
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
                 mes.OperationManagements[i].om_Type==null? xjbeizhu="未录入": xjbeizhu=mes.OperationManagements[i].om_Type;*/

                 zflist[i]=[/*xjName,xjbianhao,xjshishifang,xjjianligang,xjyanshoufang,xjiszhaobiao,xjislixiang,xjquyu,xjzhifu,xjbeizhu*/];

             }
             getzfitem(zflist);

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

function getzfitem(data) {
    var zflistdom=document.getElementById("zflist");
    var str=""
    for (var i=0;i<data.length;i++) {
        str+="<li class='table-view-cell'>"+"<a id='dy"+i+"'"+" onclick='showzfinfo(this)'>"+data[i][0]+"</a></li>"
    }
    zflistdom.innerHTML=str;
}

zfgodown();
