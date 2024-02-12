package frc.robot.command;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsytems.Arms;

public class Climbcommand extends CommandBase{

    private Joystick joy;
    private Arms climbSub = new Arms();
    boolean status = false;

public Climbcommand (Joystick inJoy, Arms climb){
    this.climbSub = climb;
    this.joy = inJoy;
}

 
    @Override
    public void execute() {
        if(joy.getRawButton(10)){
            status = !status;
            climbSub.upDown(status);
        }
        else if(joy.getRawButton(11)){
            climbSub.upDown(status);
        }


}

}
