(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[27],{uXrX:function(e,a,t){"use strict";t.r(a);t("RP/e");var r,l,n,o,c=t("izPl"),m=(t("7D5O"),t("VVh6")),i=(t("oH73"),t("5n/v")),s=(t("pko2"),t("yz32")),d=(t("/J8Y"),t("zfnJ")),p=(t("dZVJ"),t("Nf2q")),u=(t("JXWm"),t("cpGE")),h=(t("y5MA"),t("Gywv")),E=t("smUt"),f=t.n(E),y=t("Pjwa"),v=t.n(y),g=t("2cji"),b=t.n(g),k=t("sp3j"),w=t.n(k),F=t("vZkh"),S=t.n(F),C=t("+KCP"),I=t.n(C),x=(t("5L90"),t("aCNS")),R=(t("CyPW"),t("q5eX")),N=t("/0b7"),L=t.n(N),_=t("LneV"),D=(t("a/LZ"),t("G7KD")),j=t("CkN6"),V=t("zHco"),A=t("8Ehr"),O=t.n(A),J=R["a"].Item,P=(x["a"].Option,function(e){return Object.keys(e).map(function(a){return e[a]}).join(",")}),T=(r=Object(_["connect"])(function(e){var a=e._role,t=e.loading;return{_role:a,loading:t.models._role}}),l=R["a"].create(),r(n=l((o=function(e){function a(){var e,t;v()(this,a);for(var r=arguments.length,l=new Array(r),n=0;n<r;n++)l[n]=arguments[n];return t=w()(this,(e=S()(a)).call.apply(e,[this].concat(l))),t.state={expandForm:!1,selectedRows:[],formValues:{},columns:[{title:"\u89d2\u8272\u540d\u79f0",dataIndex:"roleName"},{title:"\u89d2\u8272\u63cf\u8ff0",dataIndex:"roleDescription"},{title:"\u89d2\u8272\u7c7b\u578b",dataIndex:"roleType"},{title:"\u89d2\u8272\u6570\u91cf",dataIndex:"roleNumber"},{title:"\u89d2\u8272\u6240\u5c5e\u5e73\u53f0",dataIndex:"platform"},{title:"\u64cd\u4f5c",render:function(e){return L.a.createElement(N["Fragment"],null,L.a.createElement("a",{onClick:function(){return t.previewItem(e.roleId)}},"\u914d\u7f6e"))}}]},t.handleStandardTableChange=function(e,a,r){var l=t.props.dispatch,n=t.state.formValues,o=Object.keys(a).reduce(function(e,t){var r=f()({},e);return r[t]=P(a[t]),r},{}),c={pager:{offset:e.current-1,limit:e.pageSize,param:f()({},n,o)}};if(r.field){var m={};m[r.field]=r.order,c.pager.sorter=[m]}l({type:"_role/fetch",payload:c})},t.previewItem=function(e){D["a"].push("/role/roleForm/".concat(e))},t.newItem=function(){D["a"].push("/role/roleForm")},t.handleFormReset=function(){var e=t.props,a=e.form,r=e.dispatch;a.resetFields(),t.setState({formValues:{}}),r({type:"_role/fetch",payload:{}})},t.toggleForm=function(){var e=t.state.expandForm;t.setState({expandForm:!e})},t.handleMenuClick=function(e){var a=t.props.dispatch,r=t.state.selectedRows;if(0!==r.length)switch(e.key){case"remove":a({type:"_role/remove",payload:{roleIds:r.map(function(e){return e.roleId}).join(",")},callback:function(){a({type:"_role/fetch",payload:{}}),t.setState({selectedRows:[]})}});break;default:break}},t.handleSelectRows=function(e){t.setState({selectedRows:e})},t.handleSearch=function(e){e.preventDefault();var a=t.props,r=a.dispatch,l=a.form;l.validateFields(function(e,a){if(!e){var l=f()({},a,{updatedAt:a.updatedAt&&a.updatedAt.valueOf()});t.setState({formValues:l}),console.log(l),r({type:"_role/fetch",payload:{pager:{param:l}}})}})},t}return I()(a,e),b()(a,[{key:"componentDidMount",value:function(){var e=this.props.dispatch;e({type:"_role/fetch"})}},{key:"renderSimpleForm",value:function(){var e=this.props.form.getFieldDecorator;return L.a.createElement(R["a"],{onSubmit:this.handleSearch,layout:"inline"},L.a.createElement(s["a"],{gutter:{md:8,lg:24,xl:48}},L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u89d2\u8272\u540d\u79f0"},e("roleName")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u89d2\u8272\u63cf\u8ff0"},e("roleDescription")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement("span",{className:O.a.submitButtons},L.a.createElement(p["a"],{type:"primary",htmlType:"submit"},"\u67e5\u8be2"),L.a.createElement(p["a"],{style:{marginLeft:8},onClick:this.handleFormReset},"\u91cd\u7f6e"),L.a.createElement("a",{style:{marginLeft:8},onClick:this.toggleForm},"\u5c55\u5f00 ",L.a.createElement(d["a"],{type:"down"}))))))}},{key:"renderAdvancedForm",value:function(){var e=this.props.form.getFieldDecorator;return L.a.createElement(R["a"],{onSubmit:this.handleSearch,layout:"inline"},L.a.createElement(s["a"],{gutter:{md:8,lg:24,xl:48}},L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u89d2\u8272\u540d\u79f0"},e("roleName")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u89d2\u8272\u63cf\u8ff0"},e("roleDescription")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u89d2\u8272\u7c7b\u578b"},e("roleType")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"}))))),L.a.createElement(s["a"],{gutter:{md:8,lg:24,xl:48}},L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u89d2\u8272\u6570\u91cf"},e("roleNumber")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u521b\u5efa\u7528\u6237\u7f16\u53f7"},e("userId")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u521b\u5efa\u7ec4\u7ec7\u7f16\u53f7"},e("orgId")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"}))))),L.a.createElement(s["a"],{gutter:{md:8,lg:24,xl:48}},L.a.createElement(u["a"],{md:8,sm:24},L.a.createElement(J,{label:"\u89d2\u8272\u6240\u5c5e\u5e73\u53f0"},e("platform")(L.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"}))))),L.a.createElement("div",{style:{overflow:"hidden"}},L.a.createElement("div",{style:{marginBottom:24}},L.a.createElement(p["a"],{type:"primary",htmlType:"submit"},"\u67e5\u8be2"),L.a.createElement(p["a"],{style:{marginLeft:8},onClick:this.handleFormReset},"\u91cd\u7f6e"),L.a.createElement("a",{style:{marginLeft:8},onClick:this.toggleForm},"\u6536\u8d77 ",L.a.createElement(d["a"],{type:"up"})))))}},{key:"renderForm",value:function(){var e=this.state.expandForm;return e?this.renderAdvancedForm():this.renderSimpleForm()}},{key:"render",value:function(){var e=this,a=this.props,t=a._role.data,r=void 0===t?{}:t,l=a.loading,n=this.state,o=n.selectedRows,s=n.columns,u=L.a.createElement(i["a"],{onClick:this.handleMenuClick,selectedKeys:[]},L.a.createElement(i["a"].Item,{key:"remove"},"\u5220\u9664"));return L.a.createElement(V["a"],{title:"\u67e5\u8be2\u8868\u683c"},L.a.createElement(c["a"],{bordered:!1},L.a.createElement("div",{className:O.a.tableList},L.a.createElement("div",{className:O.a.tableListForm},this.renderForm()),L.a.createElement("div",{className:O.a.tableListOperator},L.a.createElement(p["a"],{icon:"plus",type:"primary",onClick:function(){return e.newItem()}},"\u65b0\u5efa"),o.length>0&&L.a.createElement("span",null,L.a.createElement(p["a"],null,"\u6279\u91cf\u64cd\u4f5c"),L.a.createElement(m["a"],{overlay:u},L.a.createElement(p["a"],null,"\u66f4\u591a\u64cd\u4f5c ",L.a.createElement(d["a"],{type:"down"}))))),L.a.createElement(j["a"],{selectedRows:o,loading:l,data:r,columns:s,onSelectRow:this.handleSelectRows,onChange:this.handleStandardTableChange}))))}}]),a}(N["PureComponent"]),n=o))||n)||n);a["default"]=T}}]);