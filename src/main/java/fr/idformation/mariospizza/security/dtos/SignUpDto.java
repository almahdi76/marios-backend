package fr.idformation.mariospizza.security.dtos;

public record SignUpDto (String firstName, String lastName, String phonenumber,String address, char[] password) { }
