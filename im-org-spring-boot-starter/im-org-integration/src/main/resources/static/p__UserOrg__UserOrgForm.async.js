(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[33],{dfXA:function(e,a,t){"use strict";t.r(a);t("dZVJ");var r,l,n,i,c=t("Nf2q"),d=(t("RP/e"),t("izPl")),o=(t("/J8Y"),t("zfnJ")),s=t("U1Sa"),u=t.n(s),p=t("Pjwa"),m=t.n(p),h=t("2cji"),g=t.n(h),f=t("sp3j"),b=t.n(f),y=t("vZkh"),E=t.n(y),O=t("+KCP"),k=t.n(O),v=(t("y5MA"),t("Gywv")),V=(t("T+7u"),t("S/fC")),I=(t("5L90"),t("aCNS")),S=(t("CyPW"),t("q5eX")),N=t("/0b7"),w=t.n(N),C=t("LneV"),A=t("Kf7D"),T=(t("a/LZ"),t("G7KD")),F=t("zHco"),P=(t("xYz8"),t("WnAZ")),_=t("AWcK"),j=t("+n12"),D=t("DUVc"),J=S["a"].Item,M=(I["a"].Option,V["a"].RangePicker,v["a"].TextArea,r=Object(C["connect"])(function(e){var a=e._userOrg,t=e.loading;return{_userOrg:a,submitting:t.effects["_userOrg/add"]}}),l=S["a"].create(),r(n=l((i=function(e){function a(){var e,t;m()(this,a);for(var r=arguments.length,l=new Array(r),n=0;n<r;n++)l[n]=arguments[n];return t=b()(this,(e=E()(a)).call.apply(e,[this].concat(l))),t.state={beanStatus:"add"},t.handleSubmit=function(e){var a,r=t.props,l=r.dispatch,n=r.form,i=t.state.beanStatus;switch(e.preventDefault(),i){case"add":a="_userOrg/add";break;case"update":a="_userOrg/update";break;default:}n.validateFieldsAndScroll(function(e,r){if(!e){for(var n in r)r[n]&&r[n].format&&(r[n]=r[n]-0);l({type:a,payload:r,callback:function(){t.setState({beanStatus:"update"})}})}})},t.handleNavigateBack=function(){T["a"].goBack()},t.handleOrgTypeClick=function(){var e,a=t.props.form,r=a.setFieldsValue,l=a.getFieldValue,n=function(a){e.destory(),a&&a.constructor===Array&&0!==a.length&&r({orgType:a[0].codeId})},i=l("orgType");e=Object(j["a"])(w.a.createElement(_["a"],{handleOk:n,param:{codeItemId:"ORG",codeId:i}},w.a.createElement(D["a"],null)))},t}return k()(a,e),g()(a,[{key:"componentDidMount",value:function(){var e=this.props.match.params;if("{}"!==JSON.stringify(e)){this.setState({beanStatus:"update"});var a=this.props.dispatch;a({type:"_userOrg/fetchOne",payload:e})}}},{key:"render",value:function(){var e=this.state.beanStatus,a=this.props._userOrg.object,t=void 0===a?{}:a,r=this.props,l=r.submitting,n=r.form,i=n.getFieldDecorator,s=(n.getFieldValue,{labelCol:{xs:{span:24},sm:{span:7}},wrapperCol:{xs:{span:24},sm:{span:12},md:{span:10}}});return"add"===e&&(t={}),w.a.createElement(F["a"],{title:w.a.createElement(A["FormattedMessage"],{id:"app.forms.basic.title"}),content:w.a.createElement(A["FormattedMessage"],{id:"app.forms.basic.description"})},w.a.createElement(d["a"],{bordered:!1},w.a.createElement(S["a"],{onSubmit:this.handleSubmit,hideRequiredMark:!0,style:{marginTop:8}},i("userOrgId",{initialValue:t.userOrgId})(w.a.createElement(v["a"],{type:"hidden",placeholder:""})),i("userId",{initialValue:t.userId})(w.a.createElement(v["a"],{type:"hidden",placeholder:""})),i("orgId",{initialValue:t.orgId})(w.a.createElement(v["a"],{type:"hidden",placeholder:""})),w.a.createElement(J,u()({},s,{label:"\u7528\u6237\u540d\u79f0"}),i("userName",{initialValue:t.userName})(w.a.createElement(v["a"],{placeholder:""}))),i("roleId",{initialValue:t.roleId})(w.a.createElement(v["a"],{type:"hidden",placeholder:""})),i("parentOrgId",{initialValue:t.parentOrgId})(w.a.createElement(v["a"],{type:"hidden",placeholder:""})),w.a.createElement(J,u()({},s,{label:"\u7ec4\u7ec7\u7c7b\u578b"}),i("orgType",{initialValue:t.orgType})(w.a.createElement(v["a"],{placeholder:"",disabled:!0,addonAfter:w.a.createElement(o["a"],{type:"search",onClick:this.handleOrgTypeClick})}))),w.a.createElement(J,u()({},s,{label:"\u5e74\u7ea7"}),i("grade",{initialValue:t.grade})(w.a.createElement(v["a"],{placeholder:""}))),w.a.createElement(J,u()({},s,{label:"\u7ec4\u7ec7\u540d\u79f0"}),i("orgName",{initialValue:t.orgName})(w.a.createElement(v["a"],{placeholder:""}))),w.a.createElement(J,u()({},s,{label:"\u7528\u6237\u56fe\u50cfurl"}),i("userImageUrl",{initialValue:t.userImageUrl})(w.a.createElement(v["a"],{placeholder:""}))),w.a.createElement(J,u()({},s,{label:"\u7ec4\u7ec7\u7b80\u79f0"}),i("shortName",{initialValue:t.shortName})(w.a.createElement(v["a"],{placeholder:""}))),w.a.createElement(J,u()({},s,{label:"\u89d2\u8272\u540d\u79f0"}),i("roleName",{initialValue:t.roleName})(w.a.createElement(v["a"],{placeholder:""}))),w.a.createElement(J,u()({},s,{label:"\u7528\u6237\u8d26\u53f7"}),i("userAccount",{initialValue:t.userAccount})(w.a.createElement(v["a"],{placeholder:""}))))),w.a.createElement(P["a"],{style:{width:"100%"}},w.a.createElement(c["a"],{type:"primary",htmlType:"submit",onClick:this.handleSubmit,loading:l},w.a.createElement(A["FormattedMessage"],{id:"form.submit"})),w.a.createElement(c["a"],{htmlType:"button",style:{marginLeft:8},onClick:this.handleNavigateBack},"\u8fd4\u56de")))}}]),a}(N["PureComponent"]),n=i))||n)||n);a["default"]=M}}]);