package mohammad.presentation;

import lombok.Getter;

@Getter
public class Panel {
    private final String welcomePanel = """
            Welcome to meeting room reservation system!
            Please choose your rule:
            1. Customer
            2. System Manager
            3. Reserve Manager
            """;
    private final String customerPanel = """
            ----- Customer -----
            Choose your action:
            1. Get room list
            2. Request for room
            3. Get request states
            """;
    private final String systemManagerPanel = """
            ----- System Manager -----
            Choose your action:
            1. Get room list
            2. Add room
            3. Remove room
            """;
    private final String reserveManagerPanel = """
            ----- Reserve Manager -----
            Choose your action:
            1. Get request list
            2. Ack or Nak to request
            """;
}
