package plugin.livealerts.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleteArray {

    public List<String> tabCompleteArgs(String[] args) {
        int arguments = args.length;
        List<String> choices = new ArrayList<>();
        switch (arguments) {
            case 1:
                choices.add("set");
                choices.add("help");
                return choices;
            case 2:
                if (args[0].equalsIgnoreCase("help")) return Collections.emptyList();
                choices.add("audienceType");
                choices.add("messageType");
                return choices;
            case 3:
                if (args[0].equalsIgnoreCase("help")) return Collections.emptyList();
                if (args[1].equalsIgnoreCase("audienceType")) {
                    choices.add("everyone");
                    choices.add("streamerOnly");
                    return choices;
                } else if (args[1].equalsIgnoreCase("messageType")) {
                    choices.add("actionBar");
                    choices.add("bossBar");
                    choices.add("broadcast");
                    return choices;
                } else {
                    return Collections.emptyList();
                }
            default:
                return Collections.emptyList();
        }
    }


}
