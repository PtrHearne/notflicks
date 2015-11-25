package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

/**
 * Created by peter hearne on 11/22/2015.
 */
public class Main
{
    public NotflicksAPI notflicks;
    @Command(description="Add a new User")
    public void addUser (@Param(name="first name") String firstName, @Param(name="last name") String lastName,
                         @Param(name="age") String age, @Param(name="gender") String gender,
                         @Param(name="occupation") String occupation,@Param(name="email")String email)
    {
        notflicks.addUser(firstName, lastName, age, gender, occupation,email);
    }

    @Command(description="Delete a User")
    public void removeUser (@Param(name="id") Long id)
    {
        notflicks.removeUser(id);
    }
    @Command(description="Add a Movie")
    public void addMovie (@Param(name="title") String title, @Param(name="year") String year, @Param(name="url") String url)
    {
        notflicks.addMovie(title, year, url);
    }
    @Command(description="get a Movie")
    public void getMovie (@Param(name="id") Long id)
    {
        notflicks.getMovie(id);
    }
    public static void main(String[] args) throws Exception
    {
        Main main = new Main();
        Shell shell = ShellFactory.createConsoleShell("lm", "Welcome to notflicks - ?help for instructions", main);
        shell.commandLoop();
        main.notflicks.store();
    }
}
