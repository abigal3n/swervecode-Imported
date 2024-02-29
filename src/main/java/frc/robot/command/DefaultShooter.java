package frc.robot.command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsytems.Mouth;
import frc.robot.subsytems.Shooter;

public class DefaultShooter extends Command {

    private XboxController secondaryController;
    private Shooter shooterSub;
    private Mouth intakeSub;

    public DefaultShooter(XboxController secondController, Shooter shooterSub, Mouth intakeSub) {
        addRequirements(shooterSub);
        this.shooterSub = shooterSub;
        this.secondaryController = secondController;
        this.intakeSub = intakeSub;
    }

    public void execute() {

        // System.out.println("speed of one: " + shooterSub.getSpeedOne() + " speed of
        // two: " + shooterSub.getSpeedTwo());
        // align to theeuuuuuhhhhhh amp
        if (secondaryController.getAButton()) {
            // auto rotation (accpted apriltags ?)
            shooterSub.shootAmp();

            if (shooterSub.isToAmpSpeed()) {
                intakeSub.feedOn();
            }
        }
        if (secondaryController.getAButtonReleased()) {
            // go back to manual drive
            shooterSub.turnOff();
            intakeSub.feedOff();
        }

        // again for speaker
        if (secondaryController.getYButton()) {
            // auto rotation (accpted apriltags ?)
            shooterSub.shootSpeaker();

            if (shooterSub.isToSpeakerSpeed()) {
                intakeSub.feedOn();
            }
        }
        if (secondaryController.getYButtonReleased()) {
            // go back to manual drive
            shooterSub.turnOff();
            intakeSub.feedOff();
        }


        if(secondaryController.getXButton()) {
            intakeSub.feedBackwards();
            shooterSub.reverseShooters();
        }
        if(secondaryController.getXButtonReleased()){
            intakeSub.intakeOff();
            shooterSub.turnOff();
        }

        // // auto-align
        // if (joy.getRawButton(2)) {
        // // auto align subsysterm
        // }
        // if (joy.getRawButtonPressed(2)) {
        // // BAHAHA return to man drive
        // }
    }
}