# Rewarding Achievements
Addition of achievements which allow you to turn "x" amount of a Minecraft item or block for an in-game reward.

Java Development Kit: 11

Test Server Parameters:
@echo off
java -Xmx1G -Xms1G -XX:+AlwaysPreTouch -XX:+DisableExplicitGC -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:MaxGCPauseMillis=45 -XX:TargetSurvivorRatio=90 -XX:G1NewSizePercent=50 -XX:G1MaxNewSizePercent=80 -XX:InitiatingHeapOccupancyPercent=10 -XX:G1MixedGCLiveThresholdPercent=50 -jar -XX:LargePageSizeInBytes=2M -XX:+UseLargePagesInMetaspace paper-1.16.5-573.jar

Maven Build Parameters: clean insteall

Ant Build Parameters: - Enable option to create Ant build file
  - Point to Test Server patched jar
  - Add Before Launch "Run Ant Target"
