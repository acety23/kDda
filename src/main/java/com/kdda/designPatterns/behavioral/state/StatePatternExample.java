package com.kdda.designPatterns.behavioral.state;

// 状态接口
interface ElevatorState {
    void handle(ElevatorContext context);
}

// 上升状态
class MovingUpState implements ElevatorState {
    public void handle(ElevatorContext context) {
        System.out.println("The elevator is moving up.");
        // 切换到停止状态
        context.setState(new StoppedState());
    }
}

// 下降状态
class MovingDownState implements ElevatorState {
    public void handle(ElevatorContext context) {
        System.out.println("The elevator is moving down.");
        // 切换到停止状态
        context.setState(new StoppedState());
    }
}

// 停止状态
class StoppedState implements ElevatorState {
    public void handle(ElevatorContext context) {
        System.out.println("The elevator is stopped.");
        // 根据情况切换状态
        context.setState(new MovingUpState());  // 假设接下来电梯要上升
    }
}

// 环境类：电梯
class ElevatorContext {
    private ElevatorState currentState;

    public ElevatorContext() {
        // 初始状态为停止
        this.currentState = new StoppedState();
    }

    public void setState(ElevatorState state) {
        this.currentState = state;
    }

    public void request() {
        currentState.handle(this);  // 委托给当前状态处理
    }
}

// 客户端
public class StatePatternExample {
    public static void main(String[] args) {
        ElevatorContext elevator = new ElevatorContext();

        // 电梯从停止状态 -> 上升 -> 停止 -> 下降 -> 停止
        elevator.request();  // 输出：The elevator is stopped.
        elevator.request();  // 输出：The elevator is moving up.
        elevator.request();  // 输出：The elevator is stopped.
        elevator.request();  // 输出：The elevator is moving down.
        elevator.request();  // 输出：The elevator is stopped.
    }
}
