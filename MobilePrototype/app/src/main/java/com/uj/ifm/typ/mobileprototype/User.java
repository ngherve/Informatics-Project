package com.uj.ifm.typ.mobileprototype;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("Name") // in C# Param1 reference
    public String Name = "";

    @SerializedName("Username") // in C# Param2 reference
    public String Username;

    @SerializedName("Email") // in C# Param2 reference
    public String Email;

    @SerializedName("Password") // in C# Param2 reference
    public String Password;

    @SerializedName("Tel_Number") // in C# Param2 reference
    public String Tel_Number;

    @SerializedName("Address") // in C# Param2 reference
    public String Address;

    @SerializedName("Gender") // in C# Param2 reference
    public String Gender;

    @SerializedName("DOB") // in C# Param2 reference
    public String DOB;

}
