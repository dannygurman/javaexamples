package designPatterns.behavioral.chainOfResponsibility.ex2;

/**
 * Created by DannyG on 08/01/2015.
 */

public class LegalMailHandler extends AbstractEmailHandler {

    protected boolean accept(Email email) {
        return email.getFrom().endsWith("@legal.com");
    }

    protected void doHandle(Email email) {
        // move to correct folder
    }
}