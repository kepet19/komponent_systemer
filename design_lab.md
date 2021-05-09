Objectives: Assignment [DesignLab] will elaborate on the design and
architecture of the component- oriented Asteroids game. The overall objective
is to make the Asteroids game component-based

and to demonstrate reduced coupling that makes the game less resistive to
changes.

## Classwork:
* Create a coupling table for the first monolithic Asteroids game
  implementation [IntroLab].
  
| NR  | **CLASS**          | **DEPENDS ON**                                         | **DEPENDENCY DEPTH** |
| --- | ---                | ---                                                    | ---                  |
| 1   | GameKeys           |                                                        | 0                    |
| 2   | GameInputProcessor | GameKeys                                               | 1                    |
| 3   | PlayState          | GameStateManager, GameState, Player, GameKeys          | 4 \*                 |
| 4   | GameStateManager   | GameState, PlayState                                   | 5 \*                 |
| 5   | Game               | GameStateManager, Player, GameKeys, GameInputProcessor | 5 \*                 |
| 6   | SpaceObject        | Game                                                   | 5 \*                 |
| 7   | Player             | SpaceObject, Game, PlayState                           | 5 \*                 |
| 8   | GameState          | GameStateManager                                       | 6 \*                 |
| 9   | Main               | Game                                                   | 6 \*                 |

"\*" astrict betyder den er den er cyclist dependency.
fordi de bliver cyclist så stopper jeg med at tælle


| NR  | **CLASS**          | **DEPENDS ON**                                         | **DEPENDENCY DEPTH** |
| --- | ---                | ---                                                    | ---                  |
| 1   | Common             |                                                        | 0                    |
| 2   | SilentUpdate       |                                                        | 0                    |
| 3   | CommonBullet       | Common                                                 | 1                    |
| 4   | CommonEnemy        | Common                                                 | 1                    |
| 5   | CommonAsteroids    | Common                                                 | 1                    |
| 6   | Collision          | Common                                                 | 1                    |
| 7   | Core               | Common                                                 | 1                    |
| 8   | Player             | Common, CommonBullet                                   | 2                    |
| 9   | Bullet             | Common, CommonBullet                                   | 2                    |
| 10  | Enemy              | Common, CommonEnemy                                    | 2                    |
| 11  | Asteroid           | Common, CommonAsteroids                                | 2                    |
| 12  | Asteroid6Shapes    | Common, CommonAsteroids                                | 2                    |


* Perform a dependency analysis (see the textbook example) on The Monolithic
  Asteroids Game and the The NetBeans Asteroids Game [NetBeansLab2].


* Reflect on what influence Component-oriented Design has on large systems.
