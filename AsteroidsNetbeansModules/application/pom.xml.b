<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>dk.sdu.mmmi.cbse</groupId>
        <artifactId>AsteroidsNetbeansModules-parent</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>AsteroidsNetbeansModules-app</artifactId>
    <packaging>nbm-application</packaging>

    <name>AsteroidsNetbeansModules-app</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <all.clusters>${project.build.directory}/${brandingToken}</all.clusters>
        <netbeans.run.params.ide/>
        <netbeans.run.params>${netbeans.run.params.ide} --nosplash</netbeans.run.params>
    </properties>

    <dependencies>
        <!--<dependency>
            <groupId>org.netbeans.cluster</groupId>
            <artifactId>platform</artifactId>
            <version>${netbeans.version}</version>
            <type>pom</type>
        </dependency>-->
        <!-- NB runtime -->
        <dependency>
            <groupId>org.netbeans.modules</groupId>
            <artifactId>org-netbeans-core-startup</artifactId>
            <version>${netbeans.version}</version>
        </dependency>
        <!-- OSGi integration -->
        <dependency>
            <groupId>org.netbeans.api</groupId>
            <artifactId>org-netbeans-core-netigso</artifactId>
            <version>${netbeans.version}</version>
        </dependency>
        <!-- Equinox integration -->
        <dependency>
            <groupId>org.netbeans.api</groupId>
            <artifactId>org-netbeans-modules-netbinox</artifactId>
            <version>${netbeans.version}</version>
        </dependency>
        <dependency>
            <groupId>org.netbeans.api</groupId>
            <artifactId>org-netbeans-modules-nbjunit</artifactId>
            <version>${netbeans.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>Common</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!--
                <dependency>
                    <groupId>${project.groupId}</groupId>
                    <artifactId>SilentUpdate</artifactId>
                    <version>${project.version}</version>
                </dependency>
        -->
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>Player</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>Bullet</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>Asteroid</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>Enemy</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>CommonEnemy</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>Collision</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>Core</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>CommonAsteroids</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>SilentUpdate</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>${project.groupId}</groupId>
            <artifactId>CommonBullet</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.netbeans.utilities</groupId>
                <artifactId>nbm-maven-plugin</artifactId>
                <configuration>
                    <installerOsSolaris>false</installerOsSolaris>
                    <installerOsMacosx>false</installerOsMacosx>
                    <installerOsLinux>false</installerOsLinux>
                    <installerOsWindows>false</installerOsWindows>
                </configuration>
            </plugin>
            <!-- Permits NbModuleSuite to be run in integration-test phase: -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.12.2</version>
                <configuration>
                    <systemPropertyVariables>
                        <all.clusters>${all.clusters}</all.clusters>
                        <branding.token>${brandingToken}</branding.token>
                    </systemPropertyVariables>
                </configuration>
            </plugin>
        </plugins>
    </build>

    <profiles>
        <profile>
            <id>deployment</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.codehaus.mojo</groupId>
                        <artifactId>nbm-maven-plugin</artifactId>
                        <executions>
                            <execution>
                                <id>extra</id>
                                <goals>
                                    <goal>autoupdate</goal>
                                    <!-- <goal>webstart-app</goal>
                                    <goal>build-installers</goal>-->
                                </goals>
                            </execution>
                        </executions>
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>
</project>
