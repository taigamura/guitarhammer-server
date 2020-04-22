package com.guitarhammer.server.controllers.exceptions;

public class NoteNotFound extends NotFoundException {
    public NoteNotFound(String s) { super("Could not find note: " + s); }
}
