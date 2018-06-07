package com.fossil.wearables.fsl.goal;

import com.fossil.wearables.fsl.BaseProvider;
import java.util.List;

public interface GoalProvider extends BaseProvider {
    List<Goal> getAllGoals();

    List<Goal> getAllGoals(long j);

    Goal getGoal(int i);

    void removeGoal(Goal goal);

    void removeGoalInterval(GoalInterval goalInterval);

    void saveGoal(Goal goal);

    void saveGoalInterval(GoalInterval goalInterval);
}
