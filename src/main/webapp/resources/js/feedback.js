$(function () {
    jQuery("#addComment").click(function () {
        var cabRequestId = jQuery("#cabRequestId").attr("cab-request-id");
        console.log("cabRequestId>>>>" + cabRequestId);
        var comment = jQuery("#comment").val();
        console.log("comment>>>>" + comment);
        if (!comment.trim()) {
            toastr.error('Please enter a comment before posting');
            return;
        } else if (!cabRequestId.trim()) {
            toastr.error('Comment post failed!!', 'Please refresh the page and try again!');
            return;
        }

        data = {
            cabRequestId: cabRequestId,
            comment: comment
        };

        jQuery.ajax({
            url: "/addFeedbackComment",
            type: "Post",
            data: data,
            success: function (data) {
                //TODO: NEEDS COMMENTS RELOAD
                alert("Request submitted successfully!!");
                toastr.success('Comment posted successfully!!');
            },
            error: function () {
                toastr.error('Comment post failed!!', 'Please try after sometime')
            }
        });
    });
});