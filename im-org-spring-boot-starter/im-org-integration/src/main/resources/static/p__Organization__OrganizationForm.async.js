(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[24],{XPkW:function(e,a,t){"use strict";t.r(a);t("dZVJ");var l,r,n,i,c=t("Nf2q"),o=(t("RP/e"),t("izPl")),d=t("U1Sa"),s=t.n(d),p=(t("/J8Y"),t("zfnJ")),m=t("Pjwa"),u=t.n(m),h=t("2cji"),g=t.n(h),y=t("sp3j"),E=t.n(y),f=t("vZkh"),b=t.n(f),k=t("+KCP"),T=t.n(k),I=(t("y5MA"),t("Gywv")),v=(t("T+7u"),t("S/fC")),V=(t("5L90"),t("aCNS")),C=(t("CyPW"),t("q5eX")),A=t("/0b7"),S=t.n(A),O=t("LneV"),F=t("Kf7D"),N=t("a/LZ"),P=t.n(N),w=t("G7KD"),z=t("zHco"),j=(t("xYz8"),t("WnAZ")),D=t("AWcK"),q=t("+n12"),_=t("DUVc"),L=t("Kb7f"),J=C["a"].Item,M=V["a"].Option,U=(v["a"].RangePicker,I["a"].TextArea,l=Object(O["connect"])(function(e){var a=e._organization,t=e.loading;return{_organization:a,submitting:t.effects["_organization/add"]}}),r=C["a"].create(),l(n=r((i=function(e){function a(){var e,t;u()(this,a);for(var l=arguments.length,r=new Array(l),n=0;n<l;n++)r[n]=arguments[n];return t=E()(this,(e=b()(a)).call.apply(e,[this].concat(r))),t.state={beanStatus:"add"},t.handleSubmit=function(e){var a,l=t.props,r=l.dispatch,n=l.form,i=t.state.beanStatus;switch(e.preventDefault(),i){case"add":a="_organization/add";break;case"update":a="_organization/update";break;default:}n.validateFieldsAndScroll(function(e,l){if(!e){for(var n in l)l[n]&&l[n].format&&(l[n]=l[n]-0);r({type:a,payload:l,callback:function(){t.setState({beanStatus:"update"})}})}})},t.handleNavigateBack=function(){w["a"].goBack()},t.handleOrgTypeClick=function(){var e,a=t.props.form,l=a.setFieldsValue,r=a.getFieldValue,n=function(a){e.destory(),a&&a.constructor===Array&&0!==a.length&&l({orgType:a[0].codeId})},i=r("orgType");e=Object(q["a"])(S.a.createElement(D["a"],{handleOk:n,param:{codeItemId:"ORGANATION",codeId:i}},S.a.createElement(_["a"],null)))},t.handleProTypeClick=function(){var e,a=t.props.form,l=a.setFieldsValue,r=a.getFieldValue,n=function(a){e.destory(),a&&a.constructor===Array&&0!==a.length&&l({proType:a[0].codeId})},i=r("proType");e=Object(q["a"])(S.a.createElement(D["a"],{handleOk:n,param:{codeItemId:"PRO",codeId:i}},S.a.createElement(_["a"],null)))},t.handleAssociateTypeClick=function(){var e,a=t.props.form,l=a.setFieldsValue,r=a.getFieldValue,n=function(a){e.destory(),a&&a.constructor===Array&&0!==a.length&&l({associateType:a[0].codeId})},i=r("associateType");e=Object(q["a"])(S.a.createElement(D["a"],{handleOk:n,param:{codeItemId:"ASSOCIATE",codeId:i}},S.a.createElement(_["a"],null)))},t.handleParentIdClick=function(){var e,a=t.props.form,l=a.setFieldsValue,r=a.getFieldValue,n=function(a){e.destory(),a&&a.constructor===Array&&0!==a.length&&l({parentId:a[0].orgId})},i=r("parentId");e=Object(q["a"])(S.a.createElement(D["a"],{handleOk:n,param:{orgId:i}},S.a.createElement(L["a"],null)))},t}return T()(a,e),g()(a,[{key:"componentDidMount",value:function(){var e=this.props.match.params;if("{}"!==JSON.stringify(e)){this.setState({beanStatus:"update"});var a=this.props.dispatch;a({type:"_organization/fetchOne",payload:e})}}},{key:"render",value:function(){var e=this.state.beanStatus,a=this.props._organization.object,t=void 0===a?{}:a,l=this.props,r=l.submitting,n=l.form,i=n.getFieldDecorator,d=n.getFieldValue,m={labelCol:{xs:{span:24},sm:{span:7}},wrapperCol:{xs:{span:24},sm:{span:12},md:{span:10}}};return"add"===e&&(t={}),S.a.createElement(z["a"],{title:S.a.createElement(F["FormattedMessage"],{id:"app.forms.basic.title"}),content:S.a.createElement(F["FormattedMessage"],{id:"app.forms.basic.description"})},S.a.createElement(o["a"],{bordered:!1},S.a.createElement(C["a"],{onSubmit:this.handleSubmit,hideRequiredMark:!0,style:{marginTop:8}},S.a.createElement(J,null,i("orgId",{initialValue:t.orgId})(S.a.createElement(I["a"],{type:"hidden",placeholder:""}))),S.a.createElement(J,s()({},m,{label:"\u7236\u7ea7\u673a\u6784"}),i("parentId",{initialValue:t.parentId})(S.a.createElement(I["a"],{placeholder:"",disabled:!0,addonAfter:S.a.createElement(p["a"],{type:"search",onClick:this.handleParentIdClick})}))),S.a.createElement(J,s()({},m,{label:"\u7ec4\u7ec7\u7c7b\u578b"}),i("orgType",{initialValue:t.orgType,rules:[{required:!0,message:"\u5fc5\u9009\u9879"}]})(S.a.createElement(I["a"],{placeholder:"",disabled:!0,addonAfter:S.a.createElement(p["a"],{type:"search",onClick:this.handleOrgTypeClick})}))),S.a.createElement(J,s()({},m,{label:"\u7ec4\u7ec7\u63cf\u8ff0"}),i("orgDescription",{initialValue:t.orgDescription})(S.a.createElement(I["a"],{placeholder:""}))),S.a.createElement(J,s()({},m,{label:"\u7ec4\u7ec7\u540d\u79f0"}),i("orgName",{initialValue:t.orgName,rules:[{required:!0,message:"\u5fc5\u586b\u9879"}]})(S.a.createElement(I["a"],{placeholder:""}))),S.a.createElement(J,s()({},m,{label:"\u7ec4\u7ec7\u5934\u50cf\u5730\u5740"}),i("orgImageUrl",{initialValue:t.orgImageUrl})(S.a.createElement(I["a"],{placeholder:""}))),S.a.createElement(J,s()({},m,{label:"\u7ec4\u7ec7\u516c\u544a"}),i("orgAnnounce",{initialValue:t.orgAnnounce})(S.a.createElement(I["a"],{placeholder:""}))),S.a.createElement(J,s()({},m,{label:"\u662f\u5426\u6709\u6548"}),i("valid",{initialValue:t.valid||"Y",rules:[{required:!0,message:"\u5fc5\u586b\u9879"}]})(S.a.createElement(V["a"],null,S.a.createElement(M,{value:"Y"},"\u662f"),S.a.createElement(M,{value:"N"},"\u5426")))),i("userId",{initialValue:t.userId})(S.a.createElement(I["a"],{type:"hidden",placeholder:""})),S.a.createElement(J,s()({},m,{label:"\u521b\u5efa\u65f6\u95f4"}),i("createTime",{initialValue:P()(t.createTime)})(S.a.createElement(v["a"],{placeholder:""}))),S.a.createElement(J,s()({},m,{label:"\u7ec4\u7ec7\u7b80\u79f0"}),i("shortName",{initialValue:t.shortName,rules:[{required:!0,message:"\u5fc5\u586b\u9879"}]})(S.a.createElement(I["a"],{placeholder:""}))),"CLASS"===d("orgType")&&S.a.createElement(J,s()({},m,{label:"\u5e74\u7ea7"}),i("grade",{initialValue:t.grade,rules:[{required:!0,message:"\u5fc5\u586b\u9879"},{pattern:/^\d{4}$/,message:"\u5fc5\u987b\u4e3a\u56db\u4e2a\u6709\u6548\u6570\u5b57"}]})(S.a.createElement(I["a"],{placeholder:""}))),"CLASS"===d("orgType")&&S.a.createElement(J,s()({},m,{label:"\u4e13\u4e1a\u7c7b\u578b"}),i("proType",{initialValue:t.proType})(S.a.createElement(I["a"],{placeholder:"",disabled:!0,addonAfter:S.a.createElement(p["a"],{type:"search",onClick:this.handleProTypeClick})}))),"STUDENT_CLUB"===d("orgType")&&S.a.createElement(J,s()({},m,{label:"\u793e\u56e2\u7c7b\u578b"}),i("associateType",{initialValue:t.associateType})(S.a.createElement(I["a"],{placeholder:"",disabled:!0,addonAfter:S.a.createElement(p["a"],{type:"search",onClick:this.handleAssociateTypeClick})}))))),S.a.createElement(j["a"],{style:{width:"100%"}},S.a.createElement(c["a"],{type:"primary",htmlType:"submit",onClick:this.handleSubmit,loading:r},S.a.createElement(F["FormattedMessage"],{id:"form.submit"})),S.a.createElement(c["a"],{htmlType:"button",style:{marginLeft:8},onClick:this.handleNavigateBack},"\u8fd4\u56de")))}}]),a}(A["PureComponent"]),n=i))||n)||n);a["default"]=U}}]);