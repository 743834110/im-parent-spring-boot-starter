(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[9],{"0evu":function(e,t,n){e.exports={main:"antd-pro-pages-account-settings-info-main",leftmenu:"antd-pro-pages-account-settings-info-leftmenu",right:"antd-pro-pages-account-settings-info-right",title:"antd-pro-pages-account-settings-info-title"}},"N01/":function(e,t,n){"use strict";n.r(t);var a,i,s,r=n("Pjwa"),c=n.n(r),o=n("2cji"),u=n.n(o),l=n("sp3j"),m=n.n(l),p=n("vZkh"),d=n.n(p),f=n("+KCP"),g=n.n(f),h=(n("oH73"),n("5n/v")),v=n("/0b7"),y=n.n(v),M=n("LneV"),w=n("G7KD"),E=n("Kf7D"),K=n("v99g"),b=n("0evu"),k=n.n(b),z=h["a"].Item,N=(a=Object(M["connect"])(function(e){var t=e.user;return{currentUser:t.currentUser}}),a((s=function(e){function t(e){var n;c()(this,t),n=m()(this,d()(t).call(this,e)),n.getmenu=function(){var e=n.state.menuMap;return Object.keys(e).map(function(t){return y.a.createElement(z,{key:t},e[t])})},n.getRightTitle=function(){var e=n.state,t=e.selectKey,a=e.menuMap;return a[t]},n.selectKey=function(e){var t=e.key;w["a"].push("/account/settings/".concat(t)),n.setState({selectKey:t})},n.resize=function(){n.main&&requestAnimationFrame(function(){var e="inline",t=n.main.offsetWidth;n.main.offsetWidth<641&&t>400&&(e="horizontal"),window.innerWidth<768&&t>400&&(e="horizontal"),n.setState({mode:e})})};var a=e.match,i=e.location,s={base:y.a.createElement(E["FormattedMessage"],{id:"app.settings.menuMap.basic",defaultMessage:"Basic Settings"}),security:y.a.createElement(E["FormattedMessage"],{id:"app.settings.menuMap.security",defaultMessage:"Security Settings"}),binding:y.a.createElement(E["FormattedMessage"],{id:"app.settings.menuMap.binding",defaultMessage:"Account Binding"}),notification:y.a.createElement(E["FormattedMessage"],{id:"app.settings.menuMap.notification",defaultMessage:"New Message Notification"})},r=i.pathname.replace("".concat(a.path,"/"),"");return n.state={mode:"inline",menuMap:s,selectKey:s[r]?r:"base"},n}return g()(t,e),u()(t,[{key:"componentDidMount",value:function(){window.addEventListener("resize",this.resize),this.resize()}},{key:"componentWillUnmount",value:function(){window.removeEventListener("resize",this.resize)}},{key:"render",value:function(){var e=this,t=this.props,n=t.children,a=t.currentUser;if(!a.userid)return"";var i=this.state,s=i.mode,r=i.selectKey;return y.a.createElement(K["a"],null,y.a.createElement("div",{className:k.a.main,ref:function(t){e.main=t}},y.a.createElement("div",{className:k.a.leftmenu},y.a.createElement(h["a"],{mode:s,selectedKeys:[r],onClick:this.selectKey},this.getmenu())),y.a.createElement("div",{className:k.a.right},y.a.createElement("div",{className:k.a.title},this.getRightTitle()),n)))}}],[{key:"getDerivedStateFromProps",value:function(e,t){var n=e.match,a=e.location,i=a.pathname.replace("".concat(n.path,"/"),"");return i=t.menuMap[i]?i:"base",i!==t.selectKey?{selectKey:i}:null}}]),t}(v["Component"]),i=s))||i);t["default"]=N}}]);