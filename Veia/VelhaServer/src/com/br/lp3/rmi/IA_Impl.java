package com.br.lp3.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas_Banana
 */
public class IA_Impl extends UnicastRemoteObject implements IA {

    private List<Character> ocupado;

    public IA_Impl() throws RemoteException {
    }

    public List<Character> createArray() throws RemoteException {
        ocupado = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ocupado.add('?');
        }
        return ocupado;
    }

    @Override
    public int doVictoryMove(char computer) throws RemoteException {
        for (int i = 0; i < 3; i++) {
            if (ocupado.get(i * 3) == computer && ocupado.get(i * 3 + 1) == computer && ocupado.get(i * 3 + 2) == '?') {
                return i * 3 + 2;
            }
            if (ocupado.get(i * 3) == computer && ocupado.get(i * 3 + 2) == computer && ocupado.get(i * 3 + 1) == '?') {
                return i * 3 + 1;
            }
            if (ocupado.get(i * 3 + 2) == computer && ocupado.get(i * 3 + 1) == computer && ocupado.get(i * 3) == '?') {
                return i * 3;
            }
            if (ocupado.get(i) == computer && ocupado.get(i + 3) == computer && ocupado.get(i + 6) == '?') {
                return i + 6;
            }
            if (ocupado.get(i) == computer && ocupado.get(i + 6) == computer && ocupado.get(i + 3) == '?') {
                return i + 3;
            }
            if (ocupado.get(i + 6) == computer && ocupado.get(i + 3) == computer && ocupado.get(i) == '?') {
                return i;
            }
        }

        if (ocupado.get(0) == computer && ocupado.get(4) == computer && ocupado.get(8) == '?') {
            return 8;
        }
        if (ocupado.get(0) == computer && ocupado.get(8) == computer && ocupado.get(4) == '?') {
            return 4;
        }
        if (ocupado.get(8) == computer && ocupado.get(4) == computer && ocupado.get(0) == '?') {
            return 0;
        }
        if (ocupado.get(2) == computer && ocupado.get(4) == computer && ocupado.get(6) == '?') {
            return 6;
        }
        if (ocupado.get(2) == computer && ocupado.get(6) == computer && ocupado.get(4) == '?') {
            return 4;
        }
        if (ocupado.get(6) == computer && ocupado.get(4) == computer && ocupado.get(2) == '?') {
            return 2;
        }
        return -1;
    }

    @Override
    public int avoidWin(char player) throws RemoteException {
        for (int i = 0; i < 3; i++) {
            if (ocupado.get(i * 3) == player && ocupado.get(i * 3 + 1) == player && ocupado.get(i * 3 + 2) == '?') {
                return i * 3 + 2;
            }
            if (ocupado.get(i * 3) == player && ocupado.get(i * 3 + 2) == player && ocupado.get(i * 3 + 1) == '?') {
                return i * 3 + 1;
            }
            if (ocupado.get(i * 3 + 2) == player && ocupado.get(i * 3 + 1) == player && ocupado.get(i * 3) == '?') {
                return i * 3;
            }
            if (ocupado.get(i) == player && ocupado.get(i + 3) == player && ocupado.get(i + 6) == '?') {
                return i + 6;
            }
            if (ocupado.get(i) == player && ocupado.get(i + 6) == player && ocupado.get(i + 3) == '?') {
                return i + 3;
            }
            if (ocupado.get(i + 6) == player && ocupado.get(i + 3) == player && ocupado.get(i) == '?') {
                return i;
            }
        }
        if (ocupado.get(0) == player && ocupado.get(4) == player && ocupado.get(8) == '?') {
            return 8;
        }
        if (ocupado.get(0) == player && ocupado.get(8) == player && ocupado.get(4) == '?') {
            return 4;
        }
        if (ocupado.get(8) == player && ocupado.get(4) == player && ocupado.get(0) == '?') {
            return 0;
        }
        if (ocupado.get(2) == player && ocupado.get(4) == player && ocupado.get(6) == '?') {
            return 6;
        }
        if (ocupado.get(2) == player && ocupado.get(6) == player && ocupado.get(4) == '?') {
            return 4;
        }
        if (ocupado.get(6) == player && ocupado.get(4) == player && ocupado.get(2) == '?') {
            return 2;
        }
        return -1;
    }

    @Override
    public int doMove(List<Character> ocupado, char player, int pos) throws RemoteException {
        this.ocupado = ocupado;
        char computer = (player == 'x' ? 'o' : 'x');
        int move = doVictoryMove(computer);
        if (move != -1) {
            return move;
        }
        move = avoidWin(player);
        if (move != -1) {
            return move;
        }
        int playerMoves = 0;
        int computerMoves = 0;
        for (int i = 0; i < 9; i++) {
            if (ocupado.get(i) == player) {
                playerMoves++;
            } else if (ocupado.get(i) == computer) {
                computerMoves++;
            }
        }
        if (playerMoves == 0) {
            return 0;
        }
        if (playerMoves == 1) {
            if ((pos == 0 || pos == 2 || pos == 6 || pos == 8) && ocupado.get(4) == '?') {
                return 4;
            }
            if (pos == 1 && computerMoves == 1 && ocupado.get(3) == '?') {
                return 3;
            }
            if (computerMoves == 1 && ocupado.get(1) == '?') {
                return 1;
            }
            return 0;
        }
        for (int i = 0; i < 9; i++) {
            if (ocupado.get(i) == '?') {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Object> checkWin(List<Character> ocupado) throws RemoteException {
        ArrayList<Object> obj = new ArrayList();
        //WIN
        if ((ocupado.get(0) == 'x' && ocupado.get(4) == 'x' && ocupado.get(8) == 'x') || (ocupado.get(0) == 'o' && ocupado.get(4) == 'o' && ocupado.get(8) == 'o')) {
            obj.add(true);
            obj.add(ocupado.get(4));
            obj.add('d');
            obj.add(1);
            return obj;
        }
        if ((ocupado.get(2) == 'x' && ocupado.get(4) == 'x' && ocupado.get(6) == 'x') || (ocupado.get(2) == 'o' && ocupado.get(4) == 'o' && ocupado.get(6) == 'o')) {
            obj.add(true);
            obj.add(ocupado.get(4));
            obj.add('d');
            obj.add(2);
            return obj;
        }
        for (int i = 0; i < 3; i++) {
            if ((ocupado.get(i * 3) == 'x' && ocupado.get(i * 3 + 1) == 'x' && ocupado.get(i * 3 + 2) == 'x') || (ocupado.get(i * 3) == 'o' && ocupado.get(i * 3 + 1) == 'o' && ocupado.get(i * 3 + 2) == 'o')) {
                obj.add(true);
                obj.add(ocupado.get(i * 3 + 1));
                obj.add('r');
                obj.add(i);
                return obj;
            }
            if ((ocupado.get(i) == 'x' && ocupado.get(i + 3) == 'x' && ocupado.get(i + 6) == 'x') || (ocupado.get(i) == 'o' && ocupado.get(i + 3) == 'o' && ocupado.get(i + 6) == 'o')) {
                obj.add(true);
                obj.add(ocupado.get(i + 3));
                obj.add('c');
                obj.add(i);
                return obj;
            }
        }
        //TIE
        if (!ocupado.contains('?')) {
            obj.add(true);
            obj.add('t');
            obj.add(' ');
            obj.add(-1);
        }
        obj.add(false);
        return obj;
    }
}
