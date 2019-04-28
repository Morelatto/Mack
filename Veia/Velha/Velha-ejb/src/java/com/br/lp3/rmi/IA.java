package com.br.lp3.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas_Banana
 */
public interface IA extends Remote {

    public List<Character> createArray() throws RemoteException;
    
    public int doVictoryMove(char computer) throws RemoteException;

    public int avoidWin(char player) throws RemoteException;

    public int doMove(List<Character> ocupado, char player, int pos) throws RemoteException;

    public ArrayList<Object> checkWin(List<Character> ocupado) throws RemoteException;

}
