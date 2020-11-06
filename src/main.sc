require: patterns.sc
require: contexts/main.sc

init:
   bind("postProcess", function(){
        var ctx = $jsapi.context();

        var nlu = [];
        ctx.response.nlu = nlu;
        ctx.response.test = "test";
        
        nlu.push(ctx.nluResults);
        
        log(ctx.nluResults);
    
        var replies  =  ctx.response.replies || [];
        ctx.response.replies = replies;
        
        replies.push({
        type: "NluResult",
        body: {  nlu:nlu}});
        
    });