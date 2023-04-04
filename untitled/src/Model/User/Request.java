package Model.User;

public class Request {
    public Request(String requestType,Purchaser requestSender){
        numberOfRequest++;
        this.requestType=requestType;
        this.requestSender =requestSender;
        this.numberRequest=numberOfRequest;
        StringBuilder requestId = new StringBuilder();
        requestId.append(requestType.charAt(0)+"-"+requestSender.getUserName()+"-"+numberRequest);
        this.requestId=requestId.toString();
    }
    private static int numberOfRequest=0;
    private String requestType;
    private Purchaser requestSender;
    private final int numberRequest;
    private final String requestId;
    private boolean accepted = false;

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
}
