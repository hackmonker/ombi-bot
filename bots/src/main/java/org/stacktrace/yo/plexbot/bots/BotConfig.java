package org.stacktrace.yo.plexbot.bots;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class BotConfig {


    private final String host;
    private final String key;
    private final String token;
    private final String name;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("host", host)
                .append("key", key)
                .append("token", token)
                .append("name", name)
                .toString();
    }

    public boolean isValid() {
        return StringUtils.isNoneEmpty(name, host, key, token);
    }

    public static BotConfig ombi(Map<String, String> props) {
        String ombiHost = null;
        String ombiKey = null;
        String ombiBotToken = null;
        String ombiBotName = null;

        if (props != null) {
            ombiHost = props.get("OMBI_HOST");
            ombiKey = props.get("OMBI_KEY");
            ombiBotToken = props.get("OMBI_BOT_TOKEN");
            ombiBotName = props.get("OMBI_BOT_NAME");
        } else {
            ombiHost = System.getenv("OMBI_HOST");
            ombiKey = System.getenv("OMBI_KEY");
            ombiBotToken = System.getenv("OMBI_BOT_TOKEN");
            ombiBotName = System.getenv("OMBI_BOT_NAME");

        }
        return new BotConfig(ombiHost, ombiKey, ombiBotToken, ombiBotName);
    }


}
