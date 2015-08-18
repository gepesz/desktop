//----------DHTML Menu Created using AllWebMenus PRO ver 3.1-#524---------------
//C:\Budapest\LockerWAR\WebContent\common\awm\startbutton.awm
var awmMenuName='startbutton';
var awmLibraryBuild=524;
var awmLibraryPath='/awmData-startbutton';
var awmImagesPath='/awmData-startbutton';
var awmSupported=(navigator.appName + navigator.appVersion.substring(0,1)=="Netscape5" || document.all || document.layers || navigator.userAgent.indexOf('Opera')>-1)?1:0;
if (awmAltUrl!='' && !awmSupported) window.location.replace(awmAltUrl);
if (awmSupported){
var awmMenuPath;
if (document.layers) mpi=((document.images['awmMenuPathImg-startbutton'])?document.images['awmMenuPathImg-startbutton'].src:document.layers['xawmMenuPathImg-startbutton'].document.images['awmMenuPathImg-startbutton'].src); else mpi=document.images['awmMenuPathImg-startbutton'].src;
awmMenuPath=mpi.substring(0,mpi.length-16);
while (awmMenuPath.search("'")>-1) {awmMenuPath=awmMenuPath.replace("'", "&#39;");}
var nua=navigator.userAgent,scriptNo=(nua.indexOf('Safari')>-1)?7:(nua.indexOf('Gecko')>-1)?2:((document.layers)?3:((nua.indexOf('Opera')>-1)?4:((nua.indexOf('Mac')>-1)?5:((nua.indexOf('Konqueror')>-1)?6:1))));
document.write("<SCRIPT SRC='"+awmMenuPath+awmLibraryPath+"/awmlib"+scriptNo+".js'><\/SCRIPT>");
var n=null;
awmzindex=5;
}

var awmSubmenusFrame='';
var awmSubmenusFrameOffset;
var awmOptimize=0;
function awmBuildMenu(){
if (awmSupported){
awmImagesColl=['starthere_small.gif',16,16,'desktop.gif',32,32,'email.gif',32,32,'kmix.gif',32,32,'kuser.gif',32,32,'favorites.gif',32,32,'camera.gif',32,32,'sms_protocol.gif',32,32,'kwallet.gif',32,32,'korganizer.gif',32,32,'folder.gif',32,32,'settings.gif',32,32,'help.gif',32,32,'logout.gif',32,32];
awmCreateCSS(1,2,1,'#4C4C4C','#4C4C4C',n,'bold 14px sans-serif',n,'none',2,n,0,0);
awmCreateCSS(0,1,0,n,'#4C4C4C',n,n,n,'outset',2,'#C0C0C0',0,0);
awmCreateCSS(1,2,1,'#EE9F1B','#FFFFFF',n,'14px sans-serif',n,'solid',0,'#4C4C4C',0,1);
awmCreateCSS(0,2,1,'#EE9F1B','#4C4C4C',n,'bold 14px sans-serif',n,'solid',1,'#4C4C4C',0,1);
awmCreateCSS(0,2,1,'#EE9F1B','#4C4C4C',n,'italic 14px sans-serif',n,'solid',1,'#4C4C4C',0,1);
awmCreateCSS(1,2,1,'#FFFFFF','#4C4C4C',n,'bold 14px sans-serif',n,'none',2,n,0,0);
awmCreateCSS(1,2,0,'#FFFFFF','#4C4C4C',n,'14px sans-serif',n,'none',0,'#4C4C4C',0,1);
awmCreateCSS(0,2,0,'#4C4C4C','#EE9F1B',n,'bold 14px sans-serif',n,'none',0,'#4C4C4C',0,1);
awmCreateCSS(0,2,0,'#4C4C4C','#EE9F1B',n,'bold 14px sans-serif',n,'none',1,'#4C4C4C',0,1);
awmCreateCSS(1,2,0,'#FFFFFF','#4C4C4C',n,'14px sans-serif',n,'solid',1,'#4C4C4C',0,1);
awmCreateCSS(0,2,0,'#4C4C4C','#EE9F1B',n,'bold 14px sans-serif',n,'solid',1,'#4C4C4C',0,1);
var s0=awmCreateMenu(0,0,0,0,4,0,0,1,3,2,3,0,1,1,0,"","Start Here",n,1,1,0,1,n,n,100,0);
it=s0.addItemWithImages(2,3,4,"&nbsp;&nbsp;Start&nbsp;&nbsp;",n,n,"Start Here",0,0,0,3,3,3,n,n,n,"",n,n,n,n,n);
var s1=it.addSubmenu(0,1,-4,2,0,0,0,1,5,n,"",n,1,1,1,0,n,n,70);
it=s1.addItemWithImages(6,7,7,"&nbsp;&nbsp;Programs >>&nbsp;&nbsp;",n,n,"All Programs",1,1,1,3,3,3,n,n,n,"",n,n,n,n,n);
var s2=it.addSubmenu(0,0,-4,2,0,0,0,1,5,n,"",n,1,1,1,0,n,n,70);
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;Email&nbsp;&nbsp;",n,n,"Email",2,2,2,3,3,3,n,n,n,"",n,n,n,"/vh/email/StartEmail.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;Music&nbsp;&nbsp;",n,n,"Music",3,3,3,3,3,3,n,n,n,"",n,n,n,"/vh/music/StartMusic.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;IM&nbsp;&nbsp;",n,n,"IM",4,4,4,3,3,3,n,n,n,"",n,n,n,"/vh/im/StartIM.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;HTML&nbsp;&nbsp;",n,n,"HTML",5,5,5,3,3,3,n,n,n,"",n,n,n,"/vh/html/StartHTML.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;Photos&nbsp;&nbsp;",n,n,"Photos",6,6,6,3,3,3,n,n,n,"",n,n,n,"/vh/photos/StartPhotos.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;Phone/SMS&nbsp;&nbsp;",n,n,"Phone/SMS",7,7,7,3,3,3,n,n,n,"",n,n,n,"/vh/phone/StartPhone.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;Bills&nbsp;&nbsp;",n,n,"Bills",8,8,8,3,3,3,n,n,n,"",n,n,n,"/vh/bills/StartBills.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s2.addItemWithImages(9,10,10,"&nbsp;&nbsp;Notes&nbsp;&nbsp;",n,n,"Notes",9,9,9,3,3,3,n,n,n,"",n,n,n,"/vh/notes/StartNotes.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s1.addItemWithImages(6,8,8,"&nbsp;&nbsp;Documents&nbsp;&nbsp;",n,n,"Documents",10,10,10,3,3,3,n,n,n,"",n,n,n,"/vh/files/StartFiles.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s1.addItemWithImages(6,7,7,"&nbsp;&nbsp;Settings&nbsp;&nbsp;",n,n,"Settings",11,11,11,3,3,3,n,n,n,"",n,n,n,"/vh/common/ViewSettings.bg?c=content&c2=footer","contentFrame.bgFrame");
it=s1.addItemWithImages(6,7,7,"&nbsp;&nbsp;Help&nbsp;&nbsp;",n,n,"Help",12,12,12,3,3,3,n,n,n,"",n,n,n,n,n);
it=s1.addItemWithImages(6,7,7,"&nbsp;&nbsp;Logout&nbsp;&nbsp;",n,n,"Click to Logout",13,13,13,3,3,3,n,n,n,"",n,n,n,"/vh/outside/Logout.do",n);
s0.pm.buildMenu();
}}
