package plugin.livealerts.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiveAlertsTabComplete {

    public List<String> tabCompleteArgs(String[] args) {
        int arguments = args.length;
        List<String> choices = new ArrayList<>();
        switch (arguments) {
            case 1:
                choices.addAll(Arrays.asList("set","help"));
                return choices;
            case 2:
                if (args[0].equalsIgnoreCase("help")) return Collections.emptyList();
                choices.addAll(Arrays.asList("audienceType","messageType","bossBarColor"));
                return choices;
            case 3:
                if (args[0].equalsIgnoreCase("help")) return Collections.emptyList();
                if (args[1].equalsIgnoreCase("audienceType")) {
                    choices.addAll(Arrays.asList("everyone","streamerOnly"));
                    return choices;
                } else if (args[1].equalsIgnoreCase("messageType")) {
                    choices.addAll(Arrays.asList("actionBar","bossBar","broadcast"));
                    return choices;
                } else if (args[1].equalsIgnoreCase("bossBarColor")) {
                    choices.addAll(Arrays.asList("blue","green","pink","purple","red","white","yellow"));
                    return choices;
                } else {
                    return Collections.emptyList();
                }
            default:
                return Collections.emptyList();
        }
    }


}
