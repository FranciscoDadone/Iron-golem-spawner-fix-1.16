# Iron-golem-spawner-fix-1.16
Iron golem spawner fix for a bug on the minecraft version 1.16
(https://bugs.mojang.com/browse/MC-189565?attachmentViewMode=list)

# Bug
This bug creates very large logs files on the client side because of an error not rendering the iron golem entity inside the spawner.
The logs files can be extremely big (up to 100gb in 3hs with 50 spawners nearby)

# Solution
To solve this problem, the plugin changes the iron golem spawners in the player inventory when they right click a sign (shop), and it changes it with a renamed pillager spawner. And when they put the spawner, iron golems will spawn but the animation inside of the spawner will be a pillager.
Mojang said that the bug will be fixed in the 1.17 release.
