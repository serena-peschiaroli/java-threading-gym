package com.threading.gym;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gym {

    private final int totalGymMember;
    private Map<MachineType, Integer> availableMachines;

    public Gym(int totalGymMember, Map<MachineType, Integer> availableMachines) {
        this.totalGymMember = totalGymMember;
        this.availableMachines = availableMachines;
    }

    public void openForTheDay(){
        List<Thread> gymMembersRoutines;
        gymMembersRoutines = IntStream.rangeClosed(1, this.totalGymMember).mapToObj((id)->{
            Member member1 = new Member(id);
            return new Thread(() ->{
                try{
                    member1.performRoutine();
                }catch (Exception e){
                    System.out.println(e);
                }
            });
        }).collect(Collectors.toList());
    }


}
