document.forms.level.onsubmit=function(){
   var ztask=this.task.value;
   var zanswerString=this.answerString.value;
   var zvariant1=this.variant1.value;
   var zvariant2=this.variant2.value;
   var zvariant3=this.variant3.value;

$.ajax({
        type: "POST",
        url: " http://localhost:5000/api/QSelectOutOfThreePic",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({
           task: ztask,
         // task: level.task.value(),
            answerString: zanswerString,
            variant1: zvariant1,
            variant2: zvariant2,
            variant3: zvariant3,
        }),
        success: function(response) {
            console.log(response);
        },
        error: function(response) {
            console.log(response);
        }

});
return false;
};

