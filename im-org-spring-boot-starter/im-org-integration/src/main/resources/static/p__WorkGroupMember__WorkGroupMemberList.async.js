(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[38],{"Ucq/":function(e,t,a){"use strict";a.r(t);a("RP/e");var r,n,l,o,m=a("izPl"),c=(a("7D5O"),a("VVh6")),s=(a("oH73"),a("5n/v")),i=(a("pko2"),a("yz32")),d=(a("/J8Y"),a("zfnJ")),u=(a("dZVJ"),a("Nf2q")),p=(a("JXWm"),a("cpGE")),h=(a("y5MA"),a("Gywv")),f=a("smUt"),E=a.n(f),y=a("Pjwa"),b=a.n(y),v=a("2cji"),k=a.n(v),w=a("sp3j"),g=a.n(w),F=a("vZkh"),I=a.n(F),S=a("+KCP"),G=a.n(S),M=(a("5L90"),a("aCNS")),C=(a("CyPW"),a("q5eX")),R=a("/0b7"),x=a.n(R),A=a("LneV"),L=(a("a/LZ"),a("G7KD")),_=a("CkN6"),D=a("zHco"),N=a("8Ehr"),j=a.n(N),V=C["a"].Item,O=(M["a"].Option,function(e){return Object.keys(e).map(function(t){return e[t]}).join(",")}),J=(r=Object(A["connect"])(function(e){var t=e._workGroupMember,a=e.loading;return{_workGroupMember:t,loading:a.models._workGroupMember}}),n=C["a"].create(),r(l=n((o=function(e){function t(){var e,a;b()(this,t);for(var r=arguments.length,n=new Array(r),l=0;l<r;l++)n[l]=arguments[l];return a=g()(this,(e=I()(t)).call.apply(e,[this].concat(n))),a.state={expandForm:!1,selectedRows:[],formValues:{},columns:[{title:"\u7528\u6237\u8d26\u53f7",dataIndex:"userAccount"},{title:"\u7528\u6237\u540d\u79f0",dataIndex:"userName"},{title:"\u5934\u50cf\u5730\u5740",dataIndex:"memberImageUrl"},{title:"\u64cd\u4f5c",render:function(e){return x.a.createElement(R["Fragment"],null,x.a.createElement("a",{onClick:function(){return a.previewItem(e.memberId)}},"\u914d\u7f6e"))}}]},a.handleStandardTableChange=function(e,t,r){var n=a.props.dispatch,l=a.state.formValues,o=Object.keys(t).reduce(function(e,a){var r=E()({},e);return r[a]=O(t[a]),r},{}),m={pager:{offset:e.current-1,limit:e.pageSize,param:E()({},l,o)}};if(r.field){var c={};c[r.field]=r.order,m.pager.sorter=[c]}n({type:"_workGroupMember/fetch",payload:m})},a.previewItem=function(e){L["a"].push("/workGroupMember/workGroupMemberForm/".concat(e))},a.newItem=function(){L["a"].push("/workGroupMember/workGroupMemberForm")},a.handleFormReset=function(){var e=a.props,t=e.form,r=e.dispatch;t.resetFields(),a.setState({formValues:{}}),r({type:"_workGroupMember/fetch",payload:{}})},a.toggleForm=function(){var e=a.state.expandForm;a.setState({expandForm:!e})},a.handleMenuClick=function(e){var t=a.props.dispatch,r=a.state.selectedRows;if(0!==r.length)switch(e.key){case"remove":t({type:"_workGroupMember/remove",payload:{memberIds:r.map(function(e){return e.memberId}).join(",")},callback:function(){t({type:"_workGroupMember/fetch",payload:{}}),a.setState({selectedRows:[]})}});break;default:break}},a.handleSelectRows=function(e){a.setState({selectedRows:e})},a.handleSearch=function(e){e.preventDefault();var t=a.props,r=t.dispatch,n=t.form;n.validateFields(function(e,t){if(!e){var n=E()({},t,{updatedAt:t.updatedAt&&t.updatedAt.valueOf()});a.setState({formValues:n}),console.log(n),r({type:"_workGroupMember/fetch",payload:{pager:{param:n}}})}})},a}return G()(t,e),k()(t,[{key:"componentDidMount",value:function(){var e=this.props.dispatch;e({type:"_workGroupMember/fetch"})}},{key:"renderSimpleForm",value:function(){var e=this.props.form.getFieldDecorator;return x.a.createElement(C["a"],{onSubmit:this.handleSearch,layout:"inline"},x.a.createElement(i["a"],{gutter:{md:8,lg:24,xl:48}},x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement(V,{label:"\u7528\u6237ID"},e("userId")(x.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement(V,{label:"\u7528\u6237\u8d26\u53f7"},e("userAccount")(x.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement("span",{className:j.a.submitButtons},x.a.createElement(u["a"],{type:"primary",htmlType:"submit"},"\u67e5\u8be2"),x.a.createElement(u["a"],{style:{marginLeft:8},onClick:this.handleFormReset},"\u91cd\u7f6e"),x.a.createElement("a",{style:{marginLeft:8},onClick:this.toggleForm},"\u5c55\u5f00 ",x.a.createElement(d["a"],{type:"down"}))))))}},{key:"renderAdvancedForm",value:function(){var e=this.props.form.getFieldDecorator;return x.a.createElement(C["a"],{onSubmit:this.handleSearch,layout:"inline"},x.a.createElement(i["a"],{gutter:{md:8,lg:24,xl:48}},x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement(V,{label:"\u7528\u6237ID"},e("userId")(x.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement(V,{label:"\u7528\u6237\u8d26\u53f7"},e("userAccount")(x.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement(V,{label:"\u7fa4\u7ec4ID"},e("chatGroupId")(x.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"}))))),x.a.createElement(i["a"],{gutter:{md:8,lg:24,xl:48}},x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement(V,{label:"\u7528\u6237\u540d\u79f0"},e("userName")(x.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"})))),x.a.createElement(p["a"],{md:8,sm:24},x.a.createElement(V,{label:"\u5934\u50cf\u5730\u5740"},e("memberImageUrl")(x.a.createElement(h["a"],{placeholder:"\u8bf7\u8f93\u5165"}))))),x.a.createElement("div",{style:{overflow:"hidden"}},x.a.createElement("div",{style:{marginBottom:24}},x.a.createElement(u["a"],{type:"primary",htmlType:"submit"},"\u67e5\u8be2"),x.a.createElement(u["a"],{style:{marginLeft:8},onClick:this.handleFormReset},"\u91cd\u7f6e"),x.a.createElement("a",{style:{marginLeft:8},onClick:this.toggleForm},"\u6536\u8d77 ",x.a.createElement(d["a"],{type:"up"})))))}},{key:"renderForm",value:function(){var e=this.state.expandForm;return e?this.renderAdvancedForm():this.renderSimpleForm()}},{key:"render",value:function(){var e=this,t=this.props,a=t._workGroupMember.data,r=void 0===a?{}:a,n=t.loading,l=this.state,o=l.selectedRows,i=l.columns,p=x.a.createElement(s["a"],{onClick:this.handleMenuClick,selectedKeys:[]},x.a.createElement(s["a"].Item,{key:"remove"},"\u5220\u9664"));return x.a.createElement(D["a"],{title:"\u67e5\u8be2\u8868\u683c"},x.a.createElement(m["a"],{bordered:!1},x.a.createElement("div",{className:j.a.tableList},x.a.createElement("div",{className:j.a.tableListForm},this.renderForm()),x.a.createElement("div",{className:j.a.tableListOperator},x.a.createElement(u["a"],{icon:"plus",type:"primary",onClick:function(){return e.newItem()}},"\u65b0\u5efa"),o.length>0&&x.a.createElement("span",null,x.a.createElement(u["a"],null,"\u6279\u91cf\u64cd\u4f5c"),x.a.createElement(c["a"],{overlay:p},x.a.createElement(u["a"],null,"\u66f4\u591a\u64cd\u4f5c ",x.a.createElement(d["a"],{type:"down"}))))),x.a.createElement(_["a"],{selectedRows:o,loading:n,data:r,columns:i,onSelectRow:this.handleSelectRows,onChange:this.handleStandardTableChange}))))}}]),t}(R["PureComponent"]),l=o))||l)||l);t["default"]=J}}]);