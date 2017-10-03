/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diario;

/**
 *
 * @author gabriel.braga
 */

//package aplicativosaladeaula;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrador
 */
public class Diario {
    
    private HashMap<Integer, Aluno> alunos;
    private HashMap<Integer, ArrayList<Exame>> exames;
    private String disciplina;
    
    /*construtor*/
    public Diario(String disciplina){
        this.disciplina = disciplina;
        alunos = new HashMap();
        exames = new HashMap();
    }
    
    public void addAluno(Aluno aluno){
        alunos.put(aluno.getMatricula(), aluno);
    }
    
    public void addExame(Exame exame){
        
        int matricula = exame.getAluno().getMatricula();
        
        if(!exames.containsKey(matricula)){
            exames.put(matricula, new ArrayList<>());
        }
        
        exames.get(matricula).add(exame);
    
    }
    
    public HashMap<Integer, Aluno> getAlunos(){
        return alunos;
    }
    
    public Aluno getAluno(int matricula){
        return alunos.get(matricula);
    }
    
    public ArrayList<Double> getNotasAluno(int matricula){
        
        ArrayList<Double> notas = new ArrayList<>();
        
        for(Exame exame : exames.get(matricula)){
            
            notas.add(exame.getNota());
            
        }
        
        return notas;
        
    }
    
    
    
    public HashMap<Integer, ArrayList<Exame>> getDiario(){
        return exames;
    }
    
    public String getDisciplina(){
        return disciplina;
    }
    
}
    
    

