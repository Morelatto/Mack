package com.br.lp3.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Lucas_Banana
 */
@Stateless
public class GameManager implements IA {

    Registry registro;
    IA servico;

    public GameManager() throws RemoteException, NotBoundException {
        registro = LocateRegistry.getRegistry("localhost", 1099);
        servico = (IA) registro.lookup("IA");
    }

    @Override
    public List<Character> createArray() throws RemoteException {
        return servico.createArray();
    }

    @Override
    public int doVictoryMove(char computer) throws RemoteException {
        return servico.doVictoryMove(computer);
    }

    @Override
    public int avoidWin(char player) throws RemoteException {
        return servico.avoidWin(player);
    }

    @Override
    public int doMove(List<Character> ocupado, char player, int pos) throws RemoteException {
        return servico.doMove(ocupado, player, pos);
    }

    @Override
    public ArrayList<Object> checkWin(List<Character> ocupado) throws RemoteException {
        return servico.checkWin(ocupado);
    }
}
