package Model.User;

public class Request {
    public Request(String requestType,Purchaser requestSender,double amount){
        numberOfRequest++;
        this.requestType=requestType;
        this.requestSender =requestSender;
        this.amount=amount;
        this.numberRequest=numberOfRequest;
        StringBuilder requestId = new StringBuilder();
        requestId.append(requestType.charAt(0)+"-"+requestSender.getUserName()+"-"+numberRequest);
        this.requestId=requestId.toString();
    }
    public Request(String requestType,Purchaser requestSender){
        numberOfRequest++;
        this.requestType=requestType;
        this.requestSender =requestSender;
        this.numberRequest=numberOfRequest;
        StringBuilder requestId = new StringBuilder();
        requestId.append(requestType.charAt(0)+"-"+requestSender.getUserName()+"-"+numberRequest);
        this.requestId=requestId.toString();
    }
    public Request(String requestType,Comment comment){
        numberOfRequest++;
        this.requestType=requestType;
        this.numberRequest=numberOfRequest;
        this.comment=comment;
        StringBuilder requestId = new StringBuilder();
        requestId.append(requestType.charAt(0)+"-"+"com"+"-"+numberRequest);
        this.requestId=requestId.toString();
    }
    private static int numberOfRequest=0;
    private String requestType;
    private Purchaser requestSender;
    private final int numberRequest;
    private final String requestId;
    private Comment comment;
    private boolean accepted = false;
    private double amount = 0;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Purchaser getRequestSender() {
        return requestSender;
    }

    public void setRequestSender(Purchaser requestSender) {
        this.requestSender = requestSender;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
