/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sonar.samples.java.checks;

import java.util.List;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
//import org.sonar.plugins.java.api.tree.Tree.Kind;
//import static org.sonar.plugins.java.api.tree.Tree.Kind.*;

/**
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 */
@Rule( key = "ShowAllNodes" )

public class AllNodeSpy extends IssuableSubscriptionVisitor {

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return List.of( Tree.Kind.values() );
    }

    @Override
    public void leaveNode(Tree tree) {
        System.out.println( "leave tree = " + tree.kind() );
    }

    @Override
    public void visitNode(Tree tree) {
        System.out.print( "visit tree = " + tree.kind()+": " );
        switch ( tree ) {
            case MethodTree mt ->
                System.out.println( mt.simpleName() );
            case ClassTree ct-> 
                System.out.println( ct.simpleName() );
            default ->
                System.out.println( " not recognized" );
        }
    }
}
