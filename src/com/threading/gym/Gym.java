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
        // Method referencing syntax (uses double colons)
        gymMembersRoutines.forEach(Thread::start);
    }

    public Thread createSupervisor(List<Thread> threads){
        Thread supervisor = new Thread(()->{
            while(true){
                List<String> runningThreads = threads.stream().filter(Thread::isAlive).map(Thread::getName).collect(Collectors.toList());
                System.out.println(STR."\{Thread.currentThread().getName()} - \{runningThreads.size()} members currently excercising: \{runningThreads}\n");
                if(runningThreads.isEmpty()){
                    break;
                }
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e){
                    System.out.println(e);

                }


            }
            System.out.println(STR."\{Thread.currentThread().getName()} - All members are finished exercising!");

        });
        supervisor.setName("Gym Staff");
        return supervisor;
    }


}
