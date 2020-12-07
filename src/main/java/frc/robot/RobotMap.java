package frc.robot;

public class RobotMap {

    public interface DIO {
        int GRIPPER_LIMIT_1 = 1;
        int ELEVATOR_BOTTOM = 2;
        int ELEVATOR_UP = 3;

    }

    public interface CAN {
        int LEFT_TALON_1 = 3;
        int LEFT_VICTOR_2 = 4;
        int RIGHT_TALON_3 = 5;
        int RIGHT_VICTOR_4 = 6;
        int GRIPPER_LEFT_5 = 7;
        int GRIPPER_RIGHT_6 = 8;
        int ELEVATOR_1 = 9;
        int ELEVATOR_2 = 10;
        int ELEVATOR_3 = 11;
    }
}
