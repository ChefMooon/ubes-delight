package com.chefmooon.ubesdelight.common.utility;

import com.chefmooon.ubesdelight.common.block.LeafFeastSimpleBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LeafFeastUtil {

    public static int getStateByInt(BlockState state) {
        Boolean rightConnect = state.getValue(LeafFeastSimpleBlock.RIGHT_CONNECT);
        Boolean leftConnect = state.getValue(LeafFeastSimpleBlock.LEFT_CONNECT);
        if (rightConnect && leftConnect) {
            return 2; // Middle
        } else if (rightConnect) {
            return 1; // End
        } else if (leftConnect) {
            return 3; // Tip
        }
        return 0; // Base State
    }

    public static BlockState getNextState(BlockState state) {
        int stateInt = LeafFeastUtil.getStateByInt(state);
        int nextStateInt = (stateInt + 1) % 4;

        // This is the order in which the states change when the player is cycling them manually
        BlockState[] states = new BlockState[] {
                state.setValue(LeafFeastSimpleBlock.RIGHT_CONNECT, false).setValue(LeafFeastSimpleBlock.LEFT_CONNECT, false), // Base
                state.setValue(LeafFeastSimpleBlock.RIGHT_CONNECT, true).setValue(LeafFeastSimpleBlock.LEFT_CONNECT, false), // End
                state.setValue(LeafFeastSimpleBlock.RIGHT_CONNECT, true).setValue(LeafFeastSimpleBlock.LEFT_CONNECT, true), // Middle
                state.setValue(LeafFeastSimpleBlock.RIGHT_CONNECT, false).setValue(LeafFeastSimpleBlock.LEFT_CONNECT, true), // Tip
        };

        return states[nextStateInt];
    }
}
