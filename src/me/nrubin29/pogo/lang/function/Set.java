package me.nrubin29.pogo.lang.function;

import me.nrubin29.pogo.InvalidCodeException;
import me.nrubin29.pogo.Utils;
import me.nrubin29.pogo.Utils.Writable;
import me.nrubin29.pogo.lang.Block;
import me.nrubin29.pogo.lang.Variable;

public class Set extends Function {

    public Set() {
        super("set");
    }

    /*
    Usage: set(<value>, [index]) <var>
     */
    @Override
    public void run(Writable writable, Block b, String[] args, Variable receiver) throws InvalidCodeException {
        if (receiver == null) throw new InvalidCodeException("Attempted to set variable but no variable specified.");

        if (receiver.isArray()) receiver.setValue(Utils.implode(args[0], b), Integer.parseInt(args[1]));
        else receiver.setValue(Utils.implode(args[0], b));
    }
}