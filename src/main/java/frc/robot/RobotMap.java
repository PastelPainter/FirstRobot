package frc.robot;

public class RobotMap {

    public interface DIO {
        int GRIPPER_LIMIT_1 = 1;
        int ELEVATOR_BOTTOM = 2;
        int ELEVATOR_UP = 3;

    }

    public interface CAN {
        int LEFT_TALON_1 = 1;
        int LEFT_VICTOR_2 = 2;
        int RIGHT_TALON_3 = 3;
        int RIGHT_VICTOR_4 = 4;
        int GRIPPER_LEFT_5 = 5;
        int GRIPPER_RIGHT_6 = 6;
        int ELEVATOR_1 = 7;
        int ELEVATOR_2 = 8;
        int ELEVATOR_3 = 9;
    }
}
