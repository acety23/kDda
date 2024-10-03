package com.kdda.designPatterns.behavioral.command;

// 命令接口
interface Command {
    void execute();
}

// 接收者：灯
class Light {
    public void turnOn() {
        System.out.println("The light is on.");
    }

    public void turnOff() {
        System.out.println("The light is off.");
    }
}

// 具体命令类：开灯命令
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// 具体命令类：关灯命令
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// 调用者：遥控器
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// 客户端
public class CommandPatternExample {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();  // 创建接收者
        Command lightOn = new LightOnCommand(livingRoomLight);  // 创建具体命令
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();  // 调用者

        remote.setCommand(lightOn);  // 设置命令
        remote.pressButton();        // 执行命令

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
