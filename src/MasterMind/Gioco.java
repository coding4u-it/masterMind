/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterMind;

import java.util.Random;

/**
 *
 * @author coding4u
 */
public class Gioco {
    /* 
    attributi si scelgono 4 vettori da 4 elementi ciascuno per memorizzare rispettivamente
    gli elementi estratti casualmente, le scelte dell'utente e i corrispondenti secondo
    le regole del vettore nero (posizione e colore corretto) e del vettore bianco 
    (posizione non corretta, ma colore corretto).
    */
        private int [] nCasuali, nScelti;
        private char[] rNeri, rBianchi;

        public Gioco(int conta){
            nCasuali=new int[4];
            nScelti=new int[4];
            rNeri=new char[4];
            rBianchi=new char[4];
        }
        /**
         * genera un numero casuale tra 0-7 e lo inserisce nella posizione iesima del vettore
         * @param i 
         */
        public void generaCasuale(int i){
            Random rnd=new Random();
            nCasuali[i]=rnd.nextInt(8);
            rNeri[i]='.';
            rBianchi[i]='.';
        }
        /**
         * il metodo permette di inserire il numero n alla posione iesima del vettore delle scelte utente
         * @param i
         * @param n 
         */
        public void insNumeri(int i,int n){
            nScelti[i]=n;
        }
        /**
         * il metodo controlla quanli scelte sono corrette e le setta al valore nero o bianco, a seconda
         * delle regole
         * @param neriOk
         * @return 
         */
        public int chkNumeri(int neriOk){
            //controllo cifre
            neriOk=0;
            for (int i=0;i<nScelti.length;i++)
                if(nScelti[i]==nCasuali[i]){
                    rNeri[i]='N';
                    neriOk++;
                }
                else for (int j=0;j<nCasuali.length;j++)
                         if(nScelti[i]==nCasuali[j] && i!=j)
                            rBianchi[i]='B';
            return neriOk;
        }       
        /**
         * stampa l'indicazione sui numeri scelti
         * @return 
         */
        public String stampaIndicazioni(){         
            String tmp="";
            for(int i=0;i<rNeri.length;i++){
                if(rNeri[i]=='N')
                    tmp+=rNeri[i];
                else if (rBianchi[i]=='B')
                            tmp+=rBianchi[i];
                       else
                            tmp+=".";
            }
            for(int i=0;i<rBianchi.length;i++){
                rBianchi[i]='.';
                rNeri[i]='.';
            }
            return tmp;
        }
        /**
         * stampa i numeri casuali
         * @return 
         */
        public String stampaFinale(){
            String tmp="";
            for(int i:nCasuali)
                tmp+=i;
            System.out.println(tmp);
            return tmp;
        }
}