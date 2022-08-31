package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ANY_OTHER", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "'namespace'", "'{'", "'}'", "'import'", "'*'", "'.'", "'contract'", "'over'", "'clause'", "'('", "','", "')'", "':'", "';'", "'let'", "'='", "'+'", "'extends'", "'identified'", "'by'", "'enum'", "'o'", "'transaction'", "'asset'", "'concept'", "'participant'", "'String'", "'Integer'", "'Boolean'", "'DateTime'", "'pre'", "'post'", "'obl'", "'sobl'", "'pow'", "'constr'", "'or'", "'and'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'not'", "'true'", "'false'", "'IsEqual'", "'IsOwner'", "'CannotBeAssigned'", "'Date'", "'Happens'", "'WhappensBefore'", "'ShappensBefore'", "'HappensWithin'", "'WhappensBeforeE'", "'ShappensBeforeE'", "'HappensAfter'", "'Occurs'", "'powers.'", "'Triggered'", "'Activated'", "'Suspended'", "'Resumed'", "'Exerted'", "'Expired'", "'Terminated'", "'obligations.'", "'Discharged'", "'Fulfilled'", "'Violated'", "'self'", "'FulfilledObligations'", "'RevokedParty'", "'AssignedParty'", "'Rescinded'", "'Date.add'", "'seconds'", "'minutes'", "'hours'", "'days'", "'weeks'", "'months'", "'years'", "'Interval'", "'Create'", "'UnsuccessfulTermination'", "'Active'", "'InEffect'", "'Suspension'", "'SuccessfulTermination'", "'Discharge'", "'Violation'", "'Fulfillment'", "'Form'", "'UnAssign'", "'Rescission'", "'->'", "'O'", "'Obligation'", "'P'", "'Power'", "'-'", "'/'", "'Math.pow'", "'Math.abs'", "'Math.floor'", "'Math.cbrt'", "'Math.ceil'", "'Math.exp'", "'Math.sign'", "'Math.sqrt'", "'String.substring'", "'String.replaceAll'", "'String.concat'", "'String.toLowerCase'", "'String.toUpperCase'", "'String.trimEnd'", "'String.trimStart'", "'String.trim'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=8;
    public static final int RULE_ANY_OTHER=7;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMyDsl.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMyDsl.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalMyDsl.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMyDsl.g:71:1: ruleModel returns [EObject current=null] : ( ( (lv_entities_0_0= ruleEntities ) ) ( (lv_logic_1_0= ruleLogic ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_entities_0_0 = null;

        EObject lv_logic_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:77:2: ( ( ( (lv_entities_0_0= ruleEntities ) ) ( (lv_logic_1_0= ruleLogic ) ) ) )
            // InternalMyDsl.g:78:2: ( ( (lv_entities_0_0= ruleEntities ) ) ( (lv_logic_1_0= ruleLogic ) ) )
            {
            // InternalMyDsl.g:78:2: ( ( (lv_entities_0_0= ruleEntities ) ) ( (lv_logic_1_0= ruleLogic ) ) )
            // InternalMyDsl.g:79:3: ( (lv_entities_0_0= ruleEntities ) ) ( (lv_logic_1_0= ruleLogic ) )
            {
            // InternalMyDsl.g:79:3: ( (lv_entities_0_0= ruleEntities ) )
            // InternalMyDsl.g:80:4: (lv_entities_0_0= ruleEntities )
            {
            // InternalMyDsl.g:80:4: (lv_entities_0_0= ruleEntities )
            // InternalMyDsl.g:81:5: lv_entities_0_0= ruleEntities
            {

            					newCompositeNode(grammarAccess.getModelAccess().getEntitiesEntitiesParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_entities_0_0=ruleEntities();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"entities",
            						lv_entities_0_0,
            						"org.xtext.example.mydsl.MyDsl.Entities");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:98:3: ( (lv_logic_1_0= ruleLogic ) )
            // InternalMyDsl.g:99:4: (lv_logic_1_0= ruleLogic )
            {
            // InternalMyDsl.g:99:4: (lv_logic_1_0= ruleLogic )
            // InternalMyDsl.g:100:5: lv_logic_1_0= ruleLogic
            {

            					newCompositeNode(grammarAccess.getModelAccess().getLogicLogicParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_logic_1_0=ruleLogic();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"logic",
            						lv_logic_1_0,
            						"org.xtext.example.mydsl.MyDsl.Logic");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleLogic"
    // InternalMyDsl.g:121:1: entryRuleLogic returns [EObject current=null] : iv_ruleLogic= ruleLogic EOF ;
    public final EObject entryRuleLogic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogic = null;


        try {
            // InternalMyDsl.g:121:46: (iv_ruleLogic= ruleLogic EOF )
            // InternalMyDsl.g:122:2: iv_ruleLogic= ruleLogic EOF
            {
             newCompositeNode(grammarAccess.getLogicRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogic=ruleLogic();

            state._fsp--;

             current =iv_ruleLogic; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogic"


    // $ANTLR start "ruleLogic"
    // InternalMyDsl.g:128:1: ruleLogic returns [EObject current=null] : ( () otherlv_1= 'namespace' ( (lv_domainName_2_0= RULE_ID ) ) ruleImportList ( (lv_contract_4_0= ruleContract ) ) otherlv_5= '{' ( (lv_clause_6_0= ruleClause ) ) otherlv_7= '}' ) ;
    public final EObject ruleLogic() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_domainName_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_contract_4_0 = null;

        EObject lv_clause_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:134:2: ( ( () otherlv_1= 'namespace' ( (lv_domainName_2_0= RULE_ID ) ) ruleImportList ( (lv_contract_4_0= ruleContract ) ) otherlv_5= '{' ( (lv_clause_6_0= ruleClause ) ) otherlv_7= '}' ) )
            // InternalMyDsl.g:135:2: ( () otherlv_1= 'namespace' ( (lv_domainName_2_0= RULE_ID ) ) ruleImportList ( (lv_contract_4_0= ruleContract ) ) otherlv_5= '{' ( (lv_clause_6_0= ruleClause ) ) otherlv_7= '}' )
            {
            // InternalMyDsl.g:135:2: ( () otherlv_1= 'namespace' ( (lv_domainName_2_0= RULE_ID ) ) ruleImportList ( (lv_contract_4_0= ruleContract ) ) otherlv_5= '{' ( (lv_clause_6_0= ruleClause ) ) otherlv_7= '}' )
            // InternalMyDsl.g:136:3: () otherlv_1= 'namespace' ( (lv_domainName_2_0= RULE_ID ) ) ruleImportList ( (lv_contract_4_0= ruleContract ) ) otherlv_5= '{' ( (lv_clause_6_0= ruleClause ) ) otherlv_7= '}'
            {
            // InternalMyDsl.g:136:3: ()
            // InternalMyDsl.g:137:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLogicAccess().getLogicAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getLogicAccess().getNamespaceKeyword_1());
            		
            // InternalMyDsl.g:147:3: ( (lv_domainName_2_0= RULE_ID ) )
            // InternalMyDsl.g:148:4: (lv_domainName_2_0= RULE_ID )
            {
            // InternalMyDsl.g:148:4: (lv_domainName_2_0= RULE_ID )
            // InternalMyDsl.g:149:5: lv_domainName_2_0= RULE_ID
            {
            lv_domainName_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_domainName_2_0, grammarAccess.getLogicAccess().getDomainNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLogicRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domainName",
            						lv_domainName_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            			newCompositeNode(grammarAccess.getLogicAccess().getImportListParserRuleCall_3());
            		
            pushFollow(FOLLOW_5);
            ruleImportList();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:172:3: ( (lv_contract_4_0= ruleContract ) )
            // InternalMyDsl.g:173:4: (lv_contract_4_0= ruleContract )
            {
            // InternalMyDsl.g:173:4: (lv_contract_4_0= ruleContract )
            // InternalMyDsl.g:174:5: lv_contract_4_0= ruleContract
            {

            					newCompositeNode(grammarAccess.getLogicAccess().getContractContractParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_contract_4_0=ruleContract();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLogicRule());
            					}
            					set(
            						current,
            						"contract",
            						lv_contract_4_0,
            						"org.xtext.example.mydsl.MyDsl.Contract");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getLogicAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalMyDsl.g:195:3: ( (lv_clause_6_0= ruleClause ) )
            // InternalMyDsl.g:196:4: (lv_clause_6_0= ruleClause )
            {
            // InternalMyDsl.g:196:4: (lv_clause_6_0= ruleClause )
            // InternalMyDsl.g:197:5: lv_clause_6_0= ruleClause
            {

            					newCompositeNode(grammarAccess.getLogicAccess().getClauseClauseParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_8);
            lv_clause_6_0=ruleClause();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLogicRule());
            					}
            					set(
            						current,
            						"clause",
            						lv_clause_6_0,
            						"org.xtext.example.mydsl.MyDsl.Clause");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLogicAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogic"


    // $ANTLR start "entryRuleImportList"
    // InternalMyDsl.g:222:1: entryRuleImportList returns [String current=null] : iv_ruleImportList= ruleImportList EOF ;
    public final String entryRuleImportList() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImportList = null;


        try {
            // InternalMyDsl.g:222:50: (iv_ruleImportList= ruleImportList EOF )
            // InternalMyDsl.g:223:2: iv_ruleImportList= ruleImportList EOF
            {
             newCompositeNode(grammarAccess.getImportListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImportList=ruleImportList();

            state._fsp--;

             current =iv_ruleImportList.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportList"


    // $ANTLR start "ruleImportList"
    // InternalMyDsl.g:229:1: ruleImportList returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'import' (this_ID_1= RULE_ID | kw= '*' ) (kw= '.' (this_ID_4= RULE_ID | kw= '*' ) )* )* ;
    public final AntlrDatatypeRuleToken ruleImportList() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:235:2: ( (kw= 'import' (this_ID_1= RULE_ID | kw= '*' ) (kw= '.' (this_ID_4= RULE_ID | kw= '*' ) )* )* )
            // InternalMyDsl.g:236:2: (kw= 'import' (this_ID_1= RULE_ID | kw= '*' ) (kw= '.' (this_ID_4= RULE_ID | kw= '*' ) )* )*
            {
            // InternalMyDsl.g:236:2: (kw= 'import' (this_ID_1= RULE_ID | kw= '*' ) (kw= '.' (this_ID_4= RULE_ID | kw= '*' ) )* )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalMyDsl.g:237:3: kw= 'import' (this_ID_1= RULE_ID | kw= '*' ) (kw= '.' (this_ID_4= RULE_ID | kw= '*' ) )*
            	    {
            	    kw=(Token)match(input,14,FOLLOW_9); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getImportListAccess().getImportKeyword_0());
            	    		
            	    // InternalMyDsl.g:242:3: (this_ID_1= RULE_ID | kw= '*' )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==RULE_ID) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==15) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalMyDsl.g:243:4: this_ID_1= RULE_ID
            	            {
            	            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_10); 

            	            				current.merge(this_ID_1);
            	            			

            	            				newLeafNode(this_ID_1, grammarAccess.getImportListAccess().getIDTerminalRuleCall_1_0());
            	            			

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:251:4: kw= '*'
            	            {
            	            kw=(Token)match(input,15,FOLLOW_10); 

            	            				current.merge(kw);
            	            				newLeafNode(kw, grammarAccess.getImportListAccess().getAsteriskKeyword_1_1());
            	            			

            	            }
            	            break;

            	    }

            	    // InternalMyDsl.g:257:3: (kw= '.' (this_ID_4= RULE_ID | kw= '*' ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==16) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalMyDsl.g:258:4: kw= '.' (this_ID_4= RULE_ID | kw= '*' )
            	    	    {
            	    	    kw=(Token)match(input,16,FOLLOW_9); 

            	    	    				current.merge(kw);
            	    	    				newLeafNode(kw, grammarAccess.getImportListAccess().getFullStopKeyword_2_0());
            	    	    			
            	    	    // InternalMyDsl.g:263:4: (this_ID_4= RULE_ID | kw= '*' )
            	    	    int alt2=2;
            	    	    int LA2_0 = input.LA(1);

            	    	    if ( (LA2_0==RULE_ID) ) {
            	    	        alt2=1;
            	    	    }
            	    	    else if ( (LA2_0==15) ) {
            	    	        alt2=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 2, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt2) {
            	    	        case 1 :
            	    	            // InternalMyDsl.g:264:5: this_ID_4= RULE_ID
            	    	            {
            	    	            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_10); 

            	    	            					current.merge(this_ID_4);
            	    	            				

            	    	            					newLeafNode(this_ID_4, grammarAccess.getImportListAccess().getIDTerminalRuleCall_2_1_0());
            	    	            				

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // InternalMyDsl.g:272:5: kw= '*'
            	    	            {
            	    	            kw=(Token)match(input,15,FOLLOW_10); 

            	    	            					current.merge(kw);
            	    	            					newLeafNode(kw, grammarAccess.getImportListAccess().getAsteriskKeyword_2_1_1());
            	    	            				

            	    	            }
            	    	            break;

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportList"


    // $ANTLR start "entryRuleContract"
    // InternalMyDsl.g:283:1: entryRuleContract returns [EObject current=null] : iv_ruleContract= ruleContract EOF ;
    public final EObject entryRuleContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContract = null;


        try {
            // InternalMyDsl.g:283:49: (iv_ruleContract= ruleContract EOF )
            // InternalMyDsl.g:284:2: iv_ruleContract= ruleContract EOF
            {
             newCompositeNode(grammarAccess.getContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContract=ruleContract();

            state._fsp--;

             current =iv_ruleContract; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContract"


    // $ANTLR start "ruleContract"
    // InternalMyDsl.g:290:1: ruleContract returns [EObject current=null] : (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'over' ( (lv_contractAsset_3_0= RULE_ID ) ) ) ;
    public final EObject ruleContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_contractAsset_3_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:296:2: ( (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'over' ( (lv_contractAsset_3_0= RULE_ID ) ) ) )
            // InternalMyDsl.g:297:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'over' ( (lv_contractAsset_3_0= RULE_ID ) ) )
            {
            // InternalMyDsl.g:297:2: (otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'over' ( (lv_contractAsset_3_0= RULE_ID ) ) )
            // InternalMyDsl.g:298:3: otherlv_0= 'contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'over' ( (lv_contractAsset_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getContractAccess().getContractKeyword_0());
            		
            // InternalMyDsl.g:302:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:303:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:303:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:304:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getContractAccess().getOverKeyword_2());
            		
            // InternalMyDsl.g:324:3: ( (lv_contractAsset_3_0= RULE_ID ) )
            // InternalMyDsl.g:325:4: (lv_contractAsset_3_0= RULE_ID )
            {
            // InternalMyDsl.g:325:4: (lv_contractAsset_3_0= RULE_ID )
            // InternalMyDsl.g:326:5: lv_contractAsset_3_0= RULE_ID
            {
            lv_contractAsset_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_contractAsset_3_0, grammarAccess.getContractAccess().getContractAssetIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"contractAsset",
            						lv_contractAsset_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContract"


    // $ANTLR start "entryRuleClause"
    // InternalMyDsl.g:346:1: entryRuleClause returns [EObject current=null] : iv_ruleClause= ruleClause EOF ;
    public final EObject entryRuleClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClause = null;


        try {
            // InternalMyDsl.g:346:47: (iv_ruleClause= ruleClause EOF )
            // InternalMyDsl.g:347:2: iv_ruleClause= ruleClause EOF
            {
             newCompositeNode(grammarAccess.getClauseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClause=ruleClause();

            state._fsp--;

             current =iv_ruleClause; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClause"


    // $ANTLR start "ruleClause"
    // InternalMyDsl.g:353:1: ruleClause returns [EObject current=null] : (otherlv_0= 'clause' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleClauseParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnEntity_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_body_10_0= ruleClauseBody ) ) otherlv_11= '}' ) ;
    public final EObject ruleClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_returnEntity_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_body_10_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:359:2: ( (otherlv_0= 'clause' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleClauseParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnEntity_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_body_10_0= ruleClauseBody ) ) otherlv_11= '}' ) )
            // InternalMyDsl.g:360:2: (otherlv_0= 'clause' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleClauseParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnEntity_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_body_10_0= ruleClauseBody ) ) otherlv_11= '}' )
            {
            // InternalMyDsl.g:360:2: (otherlv_0= 'clause' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleClauseParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnEntity_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_body_10_0= ruleClauseBody ) ) otherlv_11= '}' )
            // InternalMyDsl.g:361:3: otherlv_0= 'clause' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleClauseParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnEntity_8_0= RULE_ID ) ) otherlv_9= '{' ( (lv_body_10_0= ruleClauseBody ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getClauseAccess().getClauseKeyword_0());
            		
            // InternalMyDsl.g:365:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:366:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:366:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:367:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getClauseAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClauseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getClauseAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMyDsl.g:387:3: ( ( (lv_params_3_0= ruleClauseParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:388:4: ( (lv_params_3_0= ruleClauseParameter ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )*
                    {
                    // InternalMyDsl.g:388:4: ( (lv_params_3_0= ruleClauseParameter ) )
                    // InternalMyDsl.g:389:5: (lv_params_3_0= ruleClauseParameter )
                    {
                    // InternalMyDsl.g:389:5: (lv_params_3_0= ruleClauseParameter )
                    // InternalMyDsl.g:390:6: lv_params_3_0= ruleClauseParameter
                    {

                    						newCompositeNode(grammarAccess.getClauseAccess().getParamsClauseParameterParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_params_3_0=ruleClauseParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getClauseRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_3_0,
                    							"org.xtext.example.mydsl.MyDsl.ClauseParameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:407:4: (otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==21) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalMyDsl.g:408:5: otherlv_4= ',' ( (lv_params_5_0= ruleClauseParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,21,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getClauseAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalMyDsl.g:412:5: ( (lv_params_5_0= ruleClauseParameter ) )
                    	    // InternalMyDsl.g:413:6: (lv_params_5_0= ruleClauseParameter )
                    	    {
                    	    // InternalMyDsl.g:413:6: (lv_params_5_0= ruleClauseParameter )
                    	    // InternalMyDsl.g:414:7: lv_params_5_0= ruleClauseParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getClauseAccess().getParamsClauseParameterParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_14);
                    	    lv_params_5_0=ruleClauseParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getClauseRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"params",
                    	    								lv_params_5_0,
                    	    								"org.xtext.example.mydsl.MyDsl.ClauseParameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_6, grammarAccess.getClauseAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getClauseAccess().getColonKeyword_5());
            		
            // InternalMyDsl.g:441:3: ( (lv_returnEntity_8_0= RULE_ID ) )
            // InternalMyDsl.g:442:4: (lv_returnEntity_8_0= RULE_ID )
            {
            // InternalMyDsl.g:442:4: (lv_returnEntity_8_0= RULE_ID )
            // InternalMyDsl.g:443:5: lv_returnEntity_8_0= RULE_ID
            {
            lv_returnEntity_8_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_returnEntity_8_0, grammarAccess.getClauseAccess().getReturnEntityIDTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClauseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"returnEntity",
            						lv_returnEntity_8_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_9=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_9, grammarAccess.getClauseAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMyDsl.g:463:3: ( (lv_body_10_0= ruleClauseBody ) )
            // InternalMyDsl.g:464:4: (lv_body_10_0= ruleClauseBody )
            {
            // InternalMyDsl.g:464:4: (lv_body_10_0= ruleClauseBody )
            // InternalMyDsl.g:465:5: lv_body_10_0= ruleClauseBody
            {

            					newCompositeNode(grammarAccess.getClauseAccess().getBodyClauseBodyParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_8);
            lv_body_10_0=ruleClauseBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getClauseRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_10_0,
            						"org.xtext.example.mydsl.MyDsl.ClauseBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getClauseAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClause"


    // $ANTLR start "entryRuleClauseParameter"
    // InternalMyDsl.g:490:1: entryRuleClauseParameter returns [EObject current=null] : iv_ruleClauseParameter= ruleClauseParameter EOF ;
    public final EObject entryRuleClauseParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClauseParameter = null;


        try {
            // InternalMyDsl.g:490:56: (iv_ruleClauseParameter= ruleClauseParameter EOF )
            // InternalMyDsl.g:491:2: iv_ruleClauseParameter= ruleClauseParameter EOF
            {
             newCompositeNode(grammarAccess.getClauseParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClauseParameter=ruleClauseParameter();

            state._fsp--;

             current =iv_ruleClauseParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClauseParameter"


    // $ANTLR start "ruleClauseParameter"
    // InternalMyDsl.g:497:1: ruleClauseParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleClauseParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:503:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalMyDsl.g:504:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalMyDsl.g:504:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalMyDsl.g:505:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalMyDsl.g:505:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDsl.g:506:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDsl.g:506:4: (lv_name_0_0= RULE_ID )
            // InternalMyDsl.g:507:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_0_0, grammarAccess.getClauseParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClauseParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getClauseParameterAccess().getColonKeyword_1());
            		
            // InternalMyDsl.g:527:3: ( (otherlv_2= RULE_ID ) )
            // InternalMyDsl.g:528:4: (otherlv_2= RULE_ID )
            {
            // InternalMyDsl.g:528:4: (otherlv_2= RULE_ID )
            // InternalMyDsl.g:529:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getClauseParameterRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getClauseParameterAccess().getEntityEntityCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClauseParameter"


    // $ANTLR start "entryRuleClauseBody"
    // InternalMyDsl.g:544:1: entryRuleClauseBody returns [EObject current=null] : iv_ruleClauseBody= ruleClauseBody EOF ;
    public final EObject entryRuleClauseBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClauseBody = null;


        try {
            // InternalMyDsl.g:544:51: (iv_ruleClauseBody= ruleClauseBody EOF )
            // InternalMyDsl.g:545:2: iv_ruleClauseBody= ruleClauseBody EOF
            {
             newCompositeNode(grammarAccess.getClauseBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClauseBody=ruleClauseBody();

            state._fsp--;

             current =iv_ruleClauseBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClauseBody"


    // $ANTLR start "ruleClauseBody"
    // InternalMyDsl.g:551:1: ruleClauseBody returns [EObject current=null] : ( (lv_commands_0_0= ruleCommand ) )* ;
    public final EObject ruleClauseBody() throws RecognitionException {
        EObject current = null;

        EObject lv_commands_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:557:2: ( ( (lv_commands_0_0= ruleCommand ) )* )
            // InternalMyDsl.g:558:2: ( (lv_commands_0_0= ruleCommand ) )*
            {
            // InternalMyDsl.g:558:2: ( (lv_commands_0_0= ruleCommand ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_ANY_OTHER)||(LA7_0>=24 && LA7_0<=25)||(LA7_0>=41 && LA7_0<=46)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMyDsl.g:559:3: (lv_commands_0_0= ruleCommand )
            	    {
            	    // InternalMyDsl.g:559:3: (lv_commands_0_0= ruleCommand )
            	    // InternalMyDsl.g:560:4: lv_commands_0_0= ruleCommand
            	    {

            	    				newCompositeNode(grammarAccess.getClauseBodyAccess().getCommandsCommandParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_17);
            	    lv_commands_0_0=ruleCommand();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getClauseBodyRule());
            	    				}
            	    				add(
            	    					current,
            	    					"commands",
            	    					lv_commands_0_0,
            	    					"org.xtext.example.mydsl.MyDsl.Command");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClauseBody"


    // $ANTLR start "entryRuleCommand"
    // InternalMyDsl.g:580:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // InternalMyDsl.g:580:48: (iv_ruleCommand= ruleCommand EOF )
            // InternalMyDsl.g:581:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // InternalMyDsl.g:587:1: ruleCommand returns [EObject current=null] : (this_Declaration_0= ruleDeclaration | this_Condition_1= ruleCondition | this_ObligationWrapper_2= ruleObligationWrapper | this_PowerWrapper_3= rulePowerWrapper | this_Constraint_4= ruleConstraint | ( () ruleOtherCommand ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject this_Declaration_0 = null;

        EObject this_Condition_1 = null;

        EObject this_ObligationWrapper_2 = null;

        EObject this_PowerWrapper_3 = null;

        EObject this_Constraint_4 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:593:2: ( (this_Declaration_0= ruleDeclaration | this_Condition_1= ruleCondition | this_ObligationWrapper_2= ruleObligationWrapper | this_PowerWrapper_3= rulePowerWrapper | this_Constraint_4= ruleConstraint | ( () ruleOtherCommand ) ) )
            // InternalMyDsl.g:594:2: (this_Declaration_0= ruleDeclaration | this_Condition_1= ruleCondition | this_ObligationWrapper_2= ruleObligationWrapper | this_PowerWrapper_3= rulePowerWrapper | this_Constraint_4= ruleConstraint | ( () ruleOtherCommand ) )
            {
            // InternalMyDsl.g:594:2: (this_Declaration_0= ruleDeclaration | this_Condition_1= ruleCondition | this_ObligationWrapper_2= ruleObligationWrapper | this_PowerWrapper_3= rulePowerWrapper | this_Constraint_4= ruleConstraint | ( () ruleOtherCommand ) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt8=1;
                }
                break;
            case 41:
            case 42:
                {
                alt8=2;
                }
                break;
            case 43:
            case 44:
                {
                alt8=3;
                }
                break;
            case 45:
                {
                alt8=4;
                }
                break;
            case 46:
                {
                alt8=5;
                }
                break;
            case EOF:
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case RULE_ANY_OTHER:
            case 24:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:595:3: this_Declaration_0= ruleDeclaration
                    {

                    			newCompositeNode(grammarAccess.getCommandAccess().getDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Declaration_0=ruleDeclaration();

                    state._fsp--;


                    			current = this_Declaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:604:3: this_Condition_1= ruleCondition
                    {

                    			newCompositeNode(grammarAccess.getCommandAccess().getConditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Condition_1=ruleCondition();

                    state._fsp--;


                    			current = this_Condition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:613:3: this_ObligationWrapper_2= ruleObligationWrapper
                    {

                    			newCompositeNode(grammarAccess.getCommandAccess().getObligationWrapperParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObligationWrapper_2=ruleObligationWrapper();

                    state._fsp--;


                    			current = this_ObligationWrapper_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:622:3: this_PowerWrapper_3= rulePowerWrapper
                    {

                    			newCompositeNode(grammarAccess.getCommandAccess().getPowerWrapperParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerWrapper_3=rulePowerWrapper();

                    state._fsp--;


                    			current = this_PowerWrapper_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:631:3: this_Constraint_4= ruleConstraint
                    {

                    			newCompositeNode(grammarAccess.getCommandAccess().getConstraintParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constraint_4=ruleConstraint();

                    state._fsp--;


                    			current = this_Constraint_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:640:3: ( () ruleOtherCommand )
                    {
                    // InternalMyDsl.g:640:3: ( () ruleOtherCommand )
                    // InternalMyDsl.g:641:4: () ruleOtherCommand
                    {
                    // InternalMyDsl.g:641:4: ()
                    // InternalMyDsl.g:642:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getCommandAccess().getCommandAction_5_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getCommandAccess().getOtherCommandParserRuleCall_5_1());
                    			
                    pushFollow(FOLLOW_2);
                    ruleOtherCommand();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleOtherCommand"
    // InternalMyDsl.g:660:1: entryRuleOtherCommand returns [String current=null] : iv_ruleOtherCommand= ruleOtherCommand EOF ;
    public final String entryRuleOtherCommand() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOtherCommand = null;


        try {
            // InternalMyDsl.g:660:52: (iv_ruleOtherCommand= ruleOtherCommand EOF )
            // InternalMyDsl.g:661:2: iv_ruleOtherCommand= ruleOtherCommand EOF
            {
             newCompositeNode(grammarAccess.getOtherCommandRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherCommand=ruleOtherCommand();

            state._fsp--;

             current =iv_ruleOtherCommand.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherCommand"


    // $ANTLR start "ruleOtherCommand"
    // InternalMyDsl.g:667:1: ruleOtherCommand returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Flexible_0= ruleFlexible kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleOtherCommand() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Flexible_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:673:2: ( (this_Flexible_0= ruleFlexible kw= ';' ) )
            // InternalMyDsl.g:674:2: (this_Flexible_0= ruleFlexible kw= ';' )
            {
            // InternalMyDsl.g:674:2: (this_Flexible_0= ruleFlexible kw= ';' )
            // InternalMyDsl.g:675:3: this_Flexible_0= ruleFlexible kw= ';'
            {

            			newCompositeNode(grammarAccess.getOtherCommandAccess().getFlexibleParserRuleCall_0());
            		
            pushFollow(FOLLOW_18);
            this_Flexible_0=ruleFlexible();

            state._fsp--;


            			current.merge(this_Flexible_0);
            		

            			afterParserOrEnumRuleCall();
            		
            kw=(Token)match(input,24,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getOtherCommandAccess().getSemicolonKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherCommand"


    // $ANTLR start "entryRuleDeclaration"
    // InternalMyDsl.g:694:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalMyDsl.g:694:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalMyDsl.g:695:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalMyDsl.g:701:1: ruleDeclaration returns [EObject current=null] : ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEntityDeclaration ) ) otherlv_4= ';' ) | this_OtherDeclaration_5= ruleOtherDeclaration ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_value_3_0 = null;

        EObject this_OtherDeclaration_5 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:707:2: ( ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEntityDeclaration ) ) otherlv_4= ';' ) | this_OtherDeclaration_5= ruleOtherDeclaration ) )
            // InternalMyDsl.g:708:2: ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEntityDeclaration ) ) otherlv_4= ';' ) | this_OtherDeclaration_5= ruleOtherDeclaration )
            {
            // InternalMyDsl.g:708:2: ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEntityDeclaration ) ) otherlv_4= ';' ) | this_OtherDeclaration_5= ruleOtherDeclaration )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==RULE_ID) ) {
                    int LA9_2 = input.LA(3);

                    if ( (LA9_2==26) ) {
                        int LA9_3 = input.LA(4);

                        if ( (LA9_3==27) ) {
                            alt9=2;
                        }
                        else if ( (LA9_3==RULE_ID) ) {
                            alt9=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:709:3: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEntityDeclaration ) ) otherlv_4= ';' )
                    {
                    // InternalMyDsl.g:709:3: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEntityDeclaration ) ) otherlv_4= ';' )
                    // InternalMyDsl.g:710:4: otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleEntityDeclaration ) ) otherlv_4= ';'
                    {
                    otherlv_0=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getDeclarationAccess().getLetKeyword_0_0());
                    			
                    // InternalMyDsl.g:714:4: ( (lv_name_1_0= RULE_ID ) )
                    // InternalMyDsl.g:715:5: (lv_name_1_0= RULE_ID )
                    {
                    // InternalMyDsl.g:715:5: (lv_name_1_0= RULE_ID )
                    // InternalMyDsl.g:716:6: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getDeclarationAccess().getNameIDTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDeclarationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,26,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_0_2());
                    			
                    // InternalMyDsl.g:736:4: ( (lv_value_3_0= ruleEntityDeclaration ) )
                    // InternalMyDsl.g:737:5: (lv_value_3_0= ruleEntityDeclaration )
                    {
                    // InternalMyDsl.g:737:5: (lv_value_3_0= ruleEntityDeclaration )
                    // InternalMyDsl.g:738:6: lv_value_3_0= ruleEntityDeclaration
                    {

                    						newCompositeNode(grammarAccess.getDeclarationAccess().getValueEntityDeclarationParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_value_3_0=ruleEntityDeclaration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.xtext.example.mydsl.MyDsl.EntityDeclaration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,24,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getSemicolonKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:761:3: this_OtherDeclaration_5= ruleOtherDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getOtherDeclarationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OtherDeclaration_5=ruleOtherDeclaration();

                    state._fsp--;


                    			current = this_OtherDeclaration_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleOtherDeclaration"
    // InternalMyDsl.g:773:1: entryRuleOtherDeclaration returns [EObject current=null] : iv_ruleOtherDeclaration= ruleOtherDeclaration EOF ;
    public final EObject entryRuleOtherDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherDeclaration = null;


        try {
            // InternalMyDsl.g:773:57: (iv_ruleOtherDeclaration= ruleOtherDeclaration EOF )
            // InternalMyDsl.g:774:2: iv_ruleOtherDeclaration= ruleOtherDeclaration EOF
            {
             newCompositeNode(grammarAccess.getOtherDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherDeclaration=ruleOtherDeclaration();

            state._fsp--;

             current =iv_ruleOtherDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherDeclaration"


    // $ANTLR start "ruleOtherDeclaration"
    // InternalMyDsl.g:780:1: ruleOtherDeclaration returns [EObject current=null] : (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '+' ruleFlexibleSpecial otherlv_5= ';' ) ;
    public final EObject ruleOtherDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMyDsl.g:786:2: ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '+' ruleFlexibleSpecial otherlv_5= ';' ) )
            // InternalMyDsl.g:787:2: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '+' ruleFlexibleSpecial otherlv_5= ';' )
            {
            // InternalMyDsl.g:787:2: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '+' ruleFlexibleSpecial otherlv_5= ';' )
            // InternalMyDsl.g:788:3: otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '+' ruleFlexibleSpecial otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getOtherDeclarationAccess().getLetKeyword_0());
            		
            // InternalMyDsl.g:792:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:793:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:793:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:794:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOtherDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOtherDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getOtherDeclarationAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_21); 

            			newLeafNode(otherlv_3, grammarAccess.getOtherDeclarationAccess().getPlusSignKeyword_3());
            		

            			newCompositeNode(grammarAccess.getOtherDeclarationAccess().getFlexibleSpecialParserRuleCall_4());
            		
            pushFollow(FOLLOW_18);
            ruleFlexibleSpecial();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            otherlv_5=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getOtherDeclarationAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherDeclaration"


    // $ANTLR start "entryRuleEntityDeclaration"
    // InternalMyDsl.g:833:1: entryRuleEntityDeclaration returns [EObject current=null] : iv_ruleEntityDeclaration= ruleEntityDeclaration EOF ;
    public final EObject entryRuleEntityDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityDeclaration = null;


        try {
            // InternalMyDsl.g:833:58: (iv_ruleEntityDeclaration= ruleEntityDeclaration EOF )
            // InternalMyDsl.g:834:2: iv_ruleEntityDeclaration= ruleEntityDeclaration EOF
            {
             newCompositeNode(grammarAccess.getEntityDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityDeclaration=ruleEntityDeclaration();

            state._fsp--;

             current =iv_ruleEntityDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityDeclaration"


    // $ANTLR start "ruleEntityDeclaration"
    // InternalMyDsl.g:840:1: ruleEntityDeclaration returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ( ( (lv_params_2_0= ruleEntityDeclarationParam ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleEntityDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:846:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ( ( (lv_params_2_0= ruleEntityDeclarationParam ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )* )? otherlv_5= '}' ) )
            // InternalMyDsl.g:847:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ( ( (lv_params_2_0= ruleEntityDeclarationParam ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )* )? otherlv_5= '}' )
            {
            // InternalMyDsl.g:847:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ( ( (lv_params_2_0= ruleEntityDeclarationParam ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )* )? otherlv_5= '}' )
            // InternalMyDsl.g:848:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '{' ( ( (lv_params_2_0= ruleEntityDeclarationParam ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )* )? otherlv_5= '}'
            {
            // InternalMyDsl.g:848:3: ( (otherlv_0= RULE_ID ) )
            // InternalMyDsl.g:849:4: (otherlv_0= RULE_ID )
            {
            // InternalMyDsl.g:849:4: (otherlv_0= RULE_ID )
            // InternalMyDsl.g:850:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityDeclarationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_0, grammarAccess.getEntityDeclarationAccess().getNameEntityCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,12,FOLLOW_22); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityDeclarationAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalMyDsl.g:865:3: ( ( (lv_params_2_0= ruleEntityDeclarationParam ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:866:4: ( (lv_params_2_0= ruleEntityDeclarationParam ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )*
                    {
                    // InternalMyDsl.g:866:4: ( (lv_params_2_0= ruleEntityDeclarationParam ) )
                    // InternalMyDsl.g:867:5: (lv_params_2_0= ruleEntityDeclarationParam )
                    {
                    // InternalMyDsl.g:867:5: (lv_params_2_0= ruleEntityDeclarationParam )
                    // InternalMyDsl.g:868:6: lv_params_2_0= ruleEntityDeclarationParam
                    {

                    						newCompositeNode(grammarAccess.getEntityDeclarationAccess().getParamsEntityDeclarationParamParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_params_2_0=ruleEntityDeclarationParam();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEntityDeclarationRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_2_0,
                    							"org.xtext.example.mydsl.MyDsl.EntityDeclarationParam");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMyDsl.g:885:4: (otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==21) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalMyDsl.g:886:5: otherlv_3= ',' ( (lv_params_4_0= ruleEntityDeclarationParam ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_4); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getEntityDeclarationAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalMyDsl.g:890:5: ( (lv_params_4_0= ruleEntityDeclarationParam ) )
                    	    // InternalMyDsl.g:891:6: (lv_params_4_0= ruleEntityDeclarationParam )
                    	    {
                    	    // InternalMyDsl.g:891:6: (lv_params_4_0= ruleEntityDeclarationParam )
                    	    // InternalMyDsl.g:892:7: lv_params_4_0= ruleEntityDeclarationParam
                    	    {

                    	    							newCompositeNode(grammarAccess.getEntityDeclarationAccess().getParamsEntityDeclarationParamParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_23);
                    	    lv_params_4_0=ruleEntityDeclarationParam();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEntityDeclarationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"params",
                    	    								lv_params_4_0,
                    	    								"org.xtext.example.mydsl.MyDsl.EntityDeclarationParam");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getEntityDeclarationAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityDeclaration"


    // $ANTLR start "entryRuleEntityDeclarationParam"
    // InternalMyDsl.g:919:1: entryRuleEntityDeclarationParam returns [EObject current=null] : iv_ruleEntityDeclarationParam= ruleEntityDeclarationParam EOF ;
    public final EObject entryRuleEntityDeclarationParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityDeclarationParam = null;


        try {
            // InternalMyDsl.g:919:63: (iv_ruleEntityDeclarationParam= ruleEntityDeclarationParam EOF )
            // InternalMyDsl.g:920:2: iv_ruleEntityDeclarationParam= ruleEntityDeclarationParam EOF
            {
             newCompositeNode(grammarAccess.getEntityDeclarationParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityDeclarationParam=ruleEntityDeclarationParam();

            state._fsp--;

             current =iv_ruleEntityDeclarationParam; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityDeclarationParam"


    // $ANTLR start "ruleEntityDeclarationParam"
    // InternalMyDsl.g:926:1: ruleEntityDeclarationParam returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleEntityDeclarationParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:932:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalMyDsl.g:933:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalMyDsl.g:933:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalMyDsl.g:934:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalMyDsl.g:934:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMyDsl.g:935:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMyDsl.g:935:4: (lv_name_0_0= RULE_ID )
            // InternalMyDsl.g:936:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEntityDeclarationParamAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityDeclarationParamRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityDeclarationParamAccess().getColonKeyword_1());
            		
            // InternalMyDsl.g:956:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalMyDsl.g:957:4: (lv_value_2_0= ruleExpression )
            {
            // InternalMyDsl.g:957:4: (lv_value_2_0= ruleExpression )
            // InternalMyDsl.g:958:5: lv_value_2_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getEntityDeclarationParamAccess().getValueExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityDeclarationParamRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityDeclarationParam"


    // $ANTLR start "entryRuleFlexible"
    // InternalMyDsl.g:979:1: entryRuleFlexible returns [String current=null] : iv_ruleFlexible= ruleFlexible EOF ;
    public final String entryRuleFlexible() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlexible = null;


        try {
            // InternalMyDsl.g:979:48: (iv_ruleFlexible= ruleFlexible EOF )
            // InternalMyDsl.g:980:2: iv_ruleFlexible= ruleFlexible EOF
            {
             newCompositeNode(grammarAccess.getFlexibleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFlexible=ruleFlexible();

            state._fsp--;

             current =iv_ruleFlexible.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlexible"


    // $ANTLR start "ruleFlexible"
    // InternalMyDsl.g:986:1: ruleFlexible returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER )* ;
    public final AntlrDatatypeRuleToken ruleFlexible() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token this_INT_2=null;
        Token this_ANY_OTHER_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:992:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER )* )
            // InternalMyDsl.g:993:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER )*
            {
            // InternalMyDsl.g:993:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER )*
            loop12:
            do {
                int alt12=5;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt12=1;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt12=2;
                    }
                    break;
                case RULE_INT:
                    {
                    alt12=3;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt12=4;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:994:3: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    			current.merge(this_ID_0);
            	    		

            	    			newLeafNode(this_ID_0, grammarAccess.getFlexibleAccess().getIDTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalMyDsl.g:1002:3: this_STRING_1= RULE_STRING
            	    {
            	    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_25); 

            	    			current.merge(this_STRING_1);
            	    		

            	    			newLeafNode(this_STRING_1, grammarAccess.getFlexibleAccess().getSTRINGTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalMyDsl.g:1010:3: this_INT_2= RULE_INT
            	    {
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_25); 

            	    			current.merge(this_INT_2);
            	    		

            	    			newLeafNode(this_INT_2, grammarAccess.getFlexibleAccess().getINTTerminalRuleCall_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalMyDsl.g:1018:3: this_ANY_OTHER_3= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_3=(Token)match(input,RULE_ANY_OTHER,FOLLOW_25); 

            	    			current.merge(this_ANY_OTHER_3);
            	    		

            	    			newLeafNode(this_ANY_OTHER_3, grammarAccess.getFlexibleAccess().getANY_OTHERTerminalRuleCall_3());
            	    		

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlexible"


    // $ANTLR start "entryRuleFlexibleSpecial"
    // InternalMyDsl.g:1029:1: entryRuleFlexibleSpecial returns [String current=null] : iv_ruleFlexibleSpecial= ruleFlexibleSpecial EOF ;
    public final String entryRuleFlexibleSpecial() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlexibleSpecial = null;


        try {
            // InternalMyDsl.g:1029:55: (iv_ruleFlexibleSpecial= ruleFlexibleSpecial EOF )
            // InternalMyDsl.g:1030:2: iv_ruleFlexibleSpecial= ruleFlexibleSpecial EOF
            {
             newCompositeNode(grammarAccess.getFlexibleSpecialRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFlexibleSpecial=ruleFlexibleSpecial();

            state._fsp--;

             current =iv_ruleFlexibleSpecial.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlexibleSpecial"


    // $ANTLR start "ruleFlexibleSpecial"
    // InternalMyDsl.g:1036:1: ruleFlexibleSpecial returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER | this_WS_4= RULE_WS | kw= '(' | kw= ')' | kw= '{' | kw= '}' | kw= '=' | kw= ',' | kw= ':' )* ;
    public final AntlrDatatypeRuleToken ruleFlexibleSpecial() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token this_INT_2=null;
        Token this_ANY_OTHER_3=null;
        Token this_WS_4=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1042:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER | this_WS_4= RULE_WS | kw= '(' | kw= ')' | kw= '{' | kw= '}' | kw= '=' | kw= ',' | kw= ':' )* )
            // InternalMyDsl.g:1043:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER | this_WS_4= RULE_WS | kw= '(' | kw= ')' | kw= '{' | kw= '}' | kw= '=' | kw= ',' | kw= ':' )*
            {
            // InternalMyDsl.g:1043:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_INT_2= RULE_INT | this_ANY_OTHER_3= RULE_ANY_OTHER | this_WS_4= RULE_WS | kw= '(' | kw= ')' | kw= '{' | kw= '}' | kw= '=' | kw= ',' | kw= ':' )*
            loop13:
            do {
                int alt13=13;
                switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt13=1;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt13=2;
                    }
                    break;
                case RULE_INT:
                    {
                    alt13=3;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt13=4;
                    }
                    break;
                case RULE_WS:
                    {
                    alt13=5;
                    }
                    break;
                case 20:
                    {
                    alt13=6;
                    }
                    break;
                case 22:
                    {
                    alt13=7;
                    }
                    break;
                case 12:
                    {
                    alt13=8;
                    }
                    break;
                case 13:
                    {
                    alt13=9;
                    }
                    break;
                case 26:
                    {
                    alt13=10;
                    }
                    break;
                case 21:
                    {
                    alt13=11;
                    }
                    break;
                case 23:
                    {
                    alt13=12;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // InternalMyDsl.g:1044:3: this_ID_0= RULE_ID
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            	    			current.merge(this_ID_0);
            	    		

            	    			newLeafNode(this_ID_0, grammarAccess.getFlexibleSpecialAccess().getIDTerminalRuleCall_0());
            	    		

            	    }
            	    break;
            	case 2 :
            	    // InternalMyDsl.g:1052:3: this_STRING_1= RULE_STRING
            	    {
            	    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_26); 

            	    			current.merge(this_STRING_1);
            	    		

            	    			newLeafNode(this_STRING_1, grammarAccess.getFlexibleSpecialAccess().getSTRINGTerminalRuleCall_1());
            	    		

            	    }
            	    break;
            	case 3 :
            	    // InternalMyDsl.g:1060:3: this_INT_2= RULE_INT
            	    {
            	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_26); 

            	    			current.merge(this_INT_2);
            	    		

            	    			newLeafNode(this_INT_2, grammarAccess.getFlexibleSpecialAccess().getINTTerminalRuleCall_2());
            	    		

            	    }
            	    break;
            	case 4 :
            	    // InternalMyDsl.g:1068:3: this_ANY_OTHER_3= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_3=(Token)match(input,RULE_ANY_OTHER,FOLLOW_26); 

            	    			current.merge(this_ANY_OTHER_3);
            	    		

            	    			newLeafNode(this_ANY_OTHER_3, grammarAccess.getFlexibleSpecialAccess().getANY_OTHERTerminalRuleCall_3());
            	    		

            	    }
            	    break;
            	case 5 :
            	    // InternalMyDsl.g:1076:3: this_WS_4= RULE_WS
            	    {
            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_26); 

            	    			current.merge(this_WS_4);
            	    		

            	    			newLeafNode(this_WS_4, grammarAccess.getFlexibleSpecialAccess().getWSTerminalRuleCall_4());
            	    		

            	    }
            	    break;
            	case 6 :
            	    // InternalMyDsl.g:1084:3: kw= '('
            	    {
            	    kw=(Token)match(input,20,FOLLOW_26); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getFlexibleSpecialAccess().getLeftParenthesisKeyword_5());
            	    		

            	    }
            	    break;
            	case 7 :
            	    // InternalMyDsl.g:1090:3: kw= ')'
            	    {
            	    kw=(Token)match(input,22,FOLLOW_26); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getFlexibleSpecialAccess().getRightParenthesisKeyword_6());
            	    		

            	    }
            	    break;
            	case 8 :
            	    // InternalMyDsl.g:1096:3: kw= '{'
            	    {
            	    kw=(Token)match(input,12,FOLLOW_26); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getFlexibleSpecialAccess().getLeftCurlyBracketKeyword_7());
            	    		

            	    }
            	    break;
            	case 9 :
            	    // InternalMyDsl.g:1102:3: kw= '}'
            	    {
            	    kw=(Token)match(input,13,FOLLOW_26); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getFlexibleSpecialAccess().getRightCurlyBracketKeyword_8());
            	    		

            	    }
            	    break;
            	case 10 :
            	    // InternalMyDsl.g:1108:3: kw= '='
            	    {
            	    kw=(Token)match(input,26,FOLLOW_26); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getFlexibleSpecialAccess().getEqualsSignKeyword_9());
            	    		

            	    }
            	    break;
            	case 11 :
            	    // InternalMyDsl.g:1114:3: kw= ','
            	    {
            	    kw=(Token)match(input,21,FOLLOW_26); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getFlexibleSpecialAccess().getCommaKeyword_10());
            	    		

            	    }
            	    break;
            	case 12 :
            	    // InternalMyDsl.g:1120:3: kw= ':'
            	    {
            	    kw=(Token)match(input,23,FOLLOW_26); 

            	    			current.merge(kw);
            	    			newLeafNode(kw, grammarAccess.getFlexibleSpecialAccess().getColonKeyword_11());
            	    		

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlexibleSpecial"


    // $ANTLR start "entryRuleEntities"
    // InternalMyDsl.g:1129:1: entryRuleEntities returns [EObject current=null] : iv_ruleEntities= ruleEntities EOF ;
    public final EObject entryRuleEntities() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntities = null;


        try {
            // InternalMyDsl.g:1129:49: (iv_ruleEntities= ruleEntities EOF )
            // InternalMyDsl.g:1130:2: iv_ruleEntities= ruleEntities EOF
            {
             newCompositeNode(grammarAccess.getEntitiesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntities=ruleEntities();

            state._fsp--;

             current =iv_ruleEntities; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntities"


    // $ANTLR start "ruleEntities"
    // InternalMyDsl.g:1136:1: ruleEntities returns [EObject current=null] : (otherlv_0= 'namespace' ( (lv_domainName_1_0= RULE_ID ) ) ruleImportList ( (lv_entities_3_0= ruleBaseEntity ) )+ ) ;
    public final EObject ruleEntities() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_domainName_1_0=null;
        EObject lv_entities_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1142:2: ( (otherlv_0= 'namespace' ( (lv_domainName_1_0= RULE_ID ) ) ruleImportList ( (lv_entities_3_0= ruleBaseEntity ) )+ ) )
            // InternalMyDsl.g:1143:2: (otherlv_0= 'namespace' ( (lv_domainName_1_0= RULE_ID ) ) ruleImportList ( (lv_entities_3_0= ruleBaseEntity ) )+ )
            {
            // InternalMyDsl.g:1143:2: (otherlv_0= 'namespace' ( (lv_domainName_1_0= RULE_ID ) ) ruleImportList ( (lv_entities_3_0= ruleBaseEntity ) )+ )
            // InternalMyDsl.g:1144:3: otherlv_0= 'namespace' ( (lv_domainName_1_0= RULE_ID ) ) ruleImportList ( (lv_entities_3_0= ruleBaseEntity ) )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEntitiesAccess().getNamespaceKeyword_0());
            		
            // InternalMyDsl.g:1148:3: ( (lv_domainName_1_0= RULE_ID ) )
            // InternalMyDsl.g:1149:4: (lv_domainName_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1149:4: (lv_domainName_1_0= RULE_ID )
            // InternalMyDsl.g:1150:5: lv_domainName_1_0= RULE_ID
            {
            lv_domainName_1_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            					newLeafNode(lv_domainName_1_0, grammarAccess.getEntitiesAccess().getDomainNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntitiesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"domainName",
            						lv_domainName_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            			newCompositeNode(grammarAccess.getEntitiesAccess().getImportListParserRuleCall_2());
            		
            pushFollow(FOLLOW_27);
            ruleImportList();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:1173:3: ( (lv_entities_3_0= ruleBaseEntity ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31||(LA14_0>=33 && LA14_0<=36)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMyDsl.g:1174:4: (lv_entities_3_0= ruleBaseEntity )
            	    {
            	    // InternalMyDsl.g:1174:4: (lv_entities_3_0= ruleBaseEntity )
            	    // InternalMyDsl.g:1175:5: lv_entities_3_0= ruleBaseEntity
            	    {

            	    					newCompositeNode(grammarAccess.getEntitiesAccess().getEntitiesBaseEntityParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_28);
            	    lv_entities_3_0=ruleBaseEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntitiesRule());
            	    					}
            	    					add(
            	    						current,
            	    						"entities",
            	    						lv_entities_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.BaseEntity");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntities"


    // $ANTLR start "entryRuleBaseEntity"
    // InternalMyDsl.g:1196:1: entryRuleBaseEntity returns [EObject current=null] : iv_ruleBaseEntity= ruleBaseEntity EOF ;
    public final EObject entryRuleBaseEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseEntity = null;


        try {
            // InternalMyDsl.g:1196:51: (iv_ruleBaseEntity= ruleBaseEntity EOF )
            // InternalMyDsl.g:1197:2: iv_ruleBaseEntity= ruleBaseEntity EOF
            {
             newCompositeNode(grammarAccess.getBaseEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBaseEntity=ruleBaseEntity();

            state._fsp--;

             current =iv_ruleBaseEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseEntity"


    // $ANTLR start "ruleBaseEntity"
    // InternalMyDsl.g:1203:1: ruleBaseEntity returns [EObject current=null] : (this_EnumEntity_0= ruleEnumEntity | this_Entity_1= ruleEntity ) ;
    public final EObject ruleBaseEntity() throws RecognitionException {
        EObject current = null;

        EObject this_EnumEntity_0 = null;

        EObject this_Entity_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1209:2: ( (this_EnumEntity_0= ruleEnumEntity | this_Entity_1= ruleEntity ) )
            // InternalMyDsl.g:1210:2: (this_EnumEntity_0= ruleEnumEntity | this_Entity_1= ruleEntity )
            {
            // InternalMyDsl.g:1210:2: (this_EnumEntity_0= ruleEnumEntity | this_Entity_1= ruleEntity )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=33 && LA15_0<=36)) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:1211:3: this_EnumEntity_0= ruleEnumEntity
                    {

                    			newCompositeNode(grammarAccess.getBaseEntityAccess().getEnumEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumEntity_0=ruleEnumEntity();

                    state._fsp--;


                    			current = this_EnumEntity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1220:3: this_Entity_1= ruleEntity
                    {

                    			newCompositeNode(grammarAccess.getBaseEntityAccess().getEntityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_1=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseEntity"


    // $ANTLR start "entryRuleEntity"
    // InternalMyDsl.g:1232:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalMyDsl.g:1232:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalMyDsl.g:1233:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalMyDsl.g:1239:1: ruleEntity returns [EObject current=null] : ( ( (lv_type_0_0= ruleEntityType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'identified' otherlv_5= 'by' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '{' ( (lv_variables_8_0= ruleVariable ) )* otherlv_9= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_type_0_0 = null;

        EObject lv_variables_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1245:2: ( ( ( (lv_type_0_0= ruleEntityType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'identified' otherlv_5= 'by' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '{' ( (lv_variables_8_0= ruleVariable ) )* otherlv_9= '}' ) )
            // InternalMyDsl.g:1246:2: ( ( (lv_type_0_0= ruleEntityType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'identified' otherlv_5= 'by' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '{' ( (lv_variables_8_0= ruleVariable ) )* otherlv_9= '}' )
            {
            // InternalMyDsl.g:1246:2: ( ( (lv_type_0_0= ruleEntityType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'identified' otherlv_5= 'by' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '{' ( (lv_variables_8_0= ruleVariable ) )* otherlv_9= '}' )
            // InternalMyDsl.g:1247:3: ( (lv_type_0_0= ruleEntityType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'identified' otherlv_5= 'by' ( (otherlv_6= RULE_ID ) ) )? otherlv_7= '{' ( (lv_variables_8_0= ruleVariable ) )* otherlv_9= '}'
            {
            // InternalMyDsl.g:1247:3: ( (lv_type_0_0= ruleEntityType ) )
            // InternalMyDsl.g:1248:4: (lv_type_0_0= ruleEntityType )
            {
            // InternalMyDsl.g:1248:4: (lv_type_0_0= ruleEntityType )
            // InternalMyDsl.g:1249:5: lv_type_0_0= ruleEntityType
            {

            					newCompositeNode(grammarAccess.getEntityAccess().getTypeEntityTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleEntityType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.xtext.example.mydsl.MyDsl.EntityType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1266:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1267:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1267:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1268:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMyDsl.g:1284:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMyDsl.g:1285:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMyDsl.g:1289:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMyDsl.g:1290:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMyDsl.g:1290:5: (otherlv_3= RULE_ID )
                    // InternalMyDsl.g:1291:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEntityRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_30); 

                    						newLeafNode(otherlv_3, grammarAccess.getEntityAccess().getParentBaseEntityCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1303:3: (otherlv_4= 'identified' otherlv_5= 'by' ( (otherlv_6= RULE_ID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1304:4: otherlv_4= 'identified' otherlv_5= 'by' ( (otherlv_6= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_31); 

                    				newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getIdentifiedKeyword_3_0());
                    			
                    otherlv_5=(Token)match(input,30,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getEntityAccess().getByKeyword_3_1());
                    			
                    // InternalMyDsl.g:1312:4: ( (otherlv_6= RULE_ID ) )
                    // InternalMyDsl.g:1313:5: (otherlv_6= RULE_ID )
                    {
                    // InternalMyDsl.g:1313:5: (otherlv_6= RULE_ID )
                    // InternalMyDsl.g:1314:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEntityRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_6, grammarAccess.getEntityAccess().getIdVariableVariableCrossReference_3_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,12,FOLLOW_32); 

            			newLeafNode(otherlv_7, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalMyDsl.g:1330:3: ( (lv_variables_8_0= ruleVariable ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==32) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMyDsl.g:1331:4: (lv_variables_8_0= ruleVariable )
            	    {
            	    // InternalMyDsl.g:1331:4: (lv_variables_8_0= ruleVariable )
            	    // InternalMyDsl.g:1332:5: lv_variables_8_0= ruleVariable
            	    {

            	    					newCompositeNode(grammarAccess.getEntityAccess().getVariablesVariableParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_variables_8_0=ruleVariable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_8_0,
            	    						"org.xtext.example.mydsl.MyDsl.Variable");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleEnumEntity"
    // InternalMyDsl.g:1357:1: entryRuleEnumEntity returns [EObject current=null] : iv_ruleEnumEntity= ruleEnumEntity EOF ;
    public final EObject entryRuleEnumEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumEntity = null;


        try {
            // InternalMyDsl.g:1357:51: (iv_ruleEnumEntity= ruleEnumEntity EOF )
            // InternalMyDsl.g:1358:2: iv_ruleEnumEntity= ruleEnumEntity EOF
            {
             newCompositeNode(grammarAccess.getEnumEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumEntity=ruleEnumEntity();

            state._fsp--;

             current =iv_ruleEnumEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumEntity"


    // $ANTLR start "ruleEnumEntity"
    // InternalMyDsl.g:1364:1: ruleEnumEntity returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_variables_5_0= ruleEnumMember ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnumEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_variables_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1370:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_variables_5_0= ruleEnumMember ) )* otherlv_6= '}' ) )
            // InternalMyDsl.g:1371:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_variables_5_0= ruleEnumMember ) )* otherlv_6= '}' )
            {
            // InternalMyDsl.g:1371:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_variables_5_0= ruleEnumMember ) )* otherlv_6= '}' )
            // InternalMyDsl.g:1372:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_variables_5_0= ruleEnumMember ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumEntityAccess().getEnumKeyword_0());
            		
            // InternalMyDsl.g:1376:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1377:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1377:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1378:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumEntityAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumEntityRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMyDsl.g:1394:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMyDsl.g:1395:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getEnumEntityAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMyDsl.g:1399:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMyDsl.g:1400:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMyDsl.g:1400:5: (otherlv_3= RULE_ID )
                    // InternalMyDsl.g:1401:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEnumEntityRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_6); 

                    						newLeafNode(otherlv_3, grammarAccess.getEnumEntityAccess().getParentBaseEntityCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FOLLOW_32); 

            			newLeafNode(otherlv_4, grammarAccess.getEnumEntityAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMyDsl.g:1417:3: ( (lv_variables_5_0= ruleEnumMember ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==32) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMyDsl.g:1418:4: (lv_variables_5_0= ruleEnumMember )
            	    {
            	    // InternalMyDsl.g:1418:4: (lv_variables_5_0= ruleEnumMember )
            	    // InternalMyDsl.g:1419:5: lv_variables_5_0= ruleEnumMember
            	    {

            	    					newCompositeNode(grammarAccess.getEnumEntityAccess().getVariablesEnumMemberParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_variables_5_0=ruleEnumMember();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEnumEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_5_0,
            	    						"org.xtext.example.mydsl.MyDsl.EnumMember");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getEnumEntityAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumEntity"


    // $ANTLR start "entryRuleEnumMember"
    // InternalMyDsl.g:1444:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalMyDsl.g:1444:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalMyDsl.g:1445:2: iv_ruleEnumMember= ruleEnumMember EOF
            {
             newCompositeNode(grammarAccess.getEnumMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumMember=ruleEnumMember();

            state._fsp--;

             current =iv_ruleEnumMember; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumMember"


    // $ANTLR start "ruleEnumMember"
    // InternalMyDsl.g:1451:1: ruleEnumMember returns [EObject current=null] : (otherlv_0= 'o' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1457:2: ( (otherlv_0= 'o' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMyDsl.g:1458:2: (otherlv_0= 'o' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMyDsl.g:1458:2: (otherlv_0= 'o' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMyDsl.g:1459:3: otherlv_0= 'o' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumMemberAccess().getOKeyword_0());
            		
            // InternalMyDsl.g:1463:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1464:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1464:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1465:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumMemberAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumMemberRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumMember"


    // $ANTLR start "entryRuleEntityType"
    // InternalMyDsl.g:1485:1: entryRuleEntityType returns [EObject current=null] : iv_ruleEntityType= ruleEntityType EOF ;
    public final EObject entryRuleEntityType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityType = null;


        try {
            // InternalMyDsl.g:1485:51: (iv_ruleEntityType= ruleEntityType EOF )
            // InternalMyDsl.g:1486:2: iv_ruleEntityType= ruleEntityType EOF
            {
             newCompositeNode(grammarAccess.getEntityTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityType=ruleEntityType();

            state._fsp--;

             current =iv_ruleEntityType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityType"


    // $ANTLR start "ruleEntityType"
    // InternalMyDsl.g:1492:1: ruleEntityType returns [EObject current=null] : ( ( (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' ) ) ) ;
    public final EObject ruleEntityType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1498:2: ( ( ( (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' ) ) ) )
            // InternalMyDsl.g:1499:2: ( ( (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' ) ) )
            {
            // InternalMyDsl.g:1499:2: ( ( (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' ) ) )
            // InternalMyDsl.g:1500:3: ( (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' ) )
            {
            // InternalMyDsl.g:1500:3: ( (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' ) )
            // InternalMyDsl.g:1501:4: (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' )
            {
            // InternalMyDsl.g:1501:4: (lv_name_0_1= 'transaction' | lv_name_0_2= 'asset' | lv_name_0_3= 'concept' | lv_name_0_4= 'participant' )
            int alt21=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt21=1;
                }
                break;
            case 34:
                {
                alt21=2;
                }
                break;
            case 35:
                {
                alt21=3;
                }
                break;
            case 36:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:1502:5: lv_name_0_1= 'transaction'
                    {
                    lv_name_0_1=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getEntityTypeAccess().getNameTransactionKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1513:5: lv_name_0_2= 'asset'
                    {
                    lv_name_0_2=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getEntityTypeAccess().getNameAssetKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1524:5: lv_name_0_3= 'concept'
                    {
                    lv_name_0_3=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getEntityTypeAccess().getNameConceptKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1535:5: lv_name_0_4= 'participant'
                    {
                    lv_name_0_4=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getEntityTypeAccess().getNameParticipantKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEntityTypeRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityType"


    // $ANTLR start "entryRuleVariable"
    // InternalMyDsl.g:1551:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalMyDsl.g:1551:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalMyDsl.g:1552:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalMyDsl.g:1558:1: ruleVariable returns [EObject current=null] : (this_PrimitiveVariable_0= rulePrimitiveVariable | this_AdvancedVariable_1= ruleAdvancedVariable ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveVariable_0 = null;

        EObject this_AdvancedVariable_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1564:2: ( (this_PrimitiveVariable_0= rulePrimitiveVariable | this_AdvancedVariable_1= ruleAdvancedVariable ) )
            // InternalMyDsl.g:1565:2: (this_PrimitiveVariable_0= rulePrimitiveVariable | this_AdvancedVariable_1= ruleAdvancedVariable )
            {
            // InternalMyDsl.g:1565:2: (this_PrimitiveVariable_0= rulePrimitiveVariable | this_AdvancedVariable_1= ruleAdvancedVariable )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_ID) ) {
                    alt22=2;
                }
                else if ( ((LA22_1>=37 && LA22_1<=40)) ) {
                    alt22=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:1566:3: this_PrimitiveVariable_0= rulePrimitiveVariable
                    {

                    			newCompositeNode(grammarAccess.getVariableAccess().getPrimitiveVariableParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveVariable_0=rulePrimitiveVariable();

                    state._fsp--;


                    			current = this_PrimitiveVariable_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1575:3: this_AdvancedVariable_1= ruleAdvancedVariable
                    {

                    			newCompositeNode(grammarAccess.getVariableAccess().getAdvancedVariableParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AdvancedVariable_1=ruleAdvancedVariable();

                    state._fsp--;


                    			current = this_AdvancedVariable_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRulePrimitiveVariable"
    // InternalMyDsl.g:1587:1: entryRulePrimitiveVariable returns [EObject current=null] : iv_rulePrimitiveVariable= rulePrimitiveVariable EOF ;
    public final EObject entryRulePrimitiveVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveVariable = null;


        try {
            // InternalMyDsl.g:1587:58: (iv_rulePrimitiveVariable= rulePrimitiveVariable EOF )
            // InternalMyDsl.g:1588:2: iv_rulePrimitiveVariable= rulePrimitiveVariable EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveVariable=rulePrimitiveVariable();

            state._fsp--;

             current =iv_rulePrimitiveVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveVariable"


    // $ANTLR start "rulePrimitiveVariable"
    // InternalMyDsl.g:1594:1: rulePrimitiveVariable returns [EObject current=null] : (otherlv_0= 'o' ( (lv_type_1_0= rulePrimitive ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject rulePrimitiveVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1600:2: ( (otherlv_0= 'o' ( (lv_type_1_0= rulePrimitive ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalMyDsl.g:1601:2: (otherlv_0= 'o' ( (lv_type_1_0= rulePrimitive ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalMyDsl.g:1601:2: (otherlv_0= 'o' ( (lv_type_1_0= rulePrimitive ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // InternalMyDsl.g:1602:3: otherlv_0= 'o' ( (lv_type_1_0= rulePrimitive ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_34); 

            			newLeafNode(otherlv_0, grammarAccess.getPrimitiveVariableAccess().getOKeyword_0());
            		
            // InternalMyDsl.g:1606:3: ( (lv_type_1_0= rulePrimitive ) )
            // InternalMyDsl.g:1607:4: (lv_type_1_0= rulePrimitive )
            {
            // InternalMyDsl.g:1607:4: (lv_type_1_0= rulePrimitive )
            // InternalMyDsl.g:1608:5: lv_type_1_0= rulePrimitive
            {

            					newCompositeNode(grammarAccess.getPrimitiveVariableAccess().getTypePrimitiveParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_type_1_0=rulePrimitive();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPrimitiveVariableRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.example.mydsl.MyDsl.Primitive");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1625:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMyDsl.g:1626:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMyDsl.g:1626:4: (lv_name_2_0= RULE_ID )
            // InternalMyDsl.g:1627:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getPrimitiveVariableAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPrimitiveVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveVariable"


    // $ANTLR start "entryRuleAdvancedVariable"
    // InternalMyDsl.g:1647:1: entryRuleAdvancedVariable returns [EObject current=null] : iv_ruleAdvancedVariable= ruleAdvancedVariable EOF ;
    public final EObject entryRuleAdvancedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvancedVariable = null;


        try {
            // InternalMyDsl.g:1647:57: (iv_ruleAdvancedVariable= ruleAdvancedVariable EOF )
            // InternalMyDsl.g:1648:2: iv_ruleAdvancedVariable= ruleAdvancedVariable EOF
            {
             newCompositeNode(grammarAccess.getAdvancedVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdvancedVariable=ruleAdvancedVariable();

            state._fsp--;

             current =iv_ruleAdvancedVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdvancedVariable"


    // $ANTLR start "ruleAdvancedVariable"
    // InternalMyDsl.g:1654:1: ruleAdvancedVariable returns [EObject current=null] : (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAdvancedVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1660:2: ( (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalMyDsl.g:1661:2: (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalMyDsl.g:1661:2: (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // InternalMyDsl.g:1662:3: otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAdvancedVariableAccess().getOKeyword_0());
            		
            // InternalMyDsl.g:1666:3: ( (otherlv_1= RULE_ID ) )
            // InternalMyDsl.g:1667:4: (otherlv_1= RULE_ID )
            {
            // InternalMyDsl.g:1667:4: (otherlv_1= RULE_ID )
            // InternalMyDsl.g:1668:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAdvancedVariableRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(otherlv_1, grammarAccess.getAdvancedVariableAccess().getTypeBaseEntityCrossReference_1_0());
            				

            }


            }

            // InternalMyDsl.g:1679:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMyDsl.g:1680:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMyDsl.g:1680:4: (lv_name_2_0= RULE_ID )
            // InternalMyDsl.g:1681:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getAdvancedVariableAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAdvancedVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdvancedVariable"


    // $ANTLR start "entryRulePrimitive"
    // InternalMyDsl.g:1701:1: entryRulePrimitive returns [EObject current=null] : iv_rulePrimitive= rulePrimitive EOF ;
    public final EObject entryRulePrimitive() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitive = null;


        try {
            // InternalMyDsl.g:1701:50: (iv_rulePrimitive= rulePrimitive EOF )
            // InternalMyDsl.g:1702:2: iv_rulePrimitive= rulePrimitive EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitive=rulePrimitive();

            state._fsp--;

             current =iv_rulePrimitive; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitive"


    // $ANTLR start "rulePrimitive"
    // InternalMyDsl.g:1708:1: rulePrimitive returns [EObject current=null] : ( ( (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' ) ) ) ;
    public final EObject rulePrimitive() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:1714:2: ( ( ( (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' ) ) ) )
            // InternalMyDsl.g:1715:2: ( ( (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' ) ) )
            {
            // InternalMyDsl.g:1715:2: ( ( (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' ) ) )
            // InternalMyDsl.g:1716:3: ( (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' ) )
            {
            // InternalMyDsl.g:1716:3: ( (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' ) )
            // InternalMyDsl.g:1717:4: (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' )
            {
            // InternalMyDsl.g:1717:4: (lv_name_0_1= 'String' | lv_name_0_2= 'Integer' | lv_name_0_3= 'Boolean' | lv_name_0_4= 'DateTime' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt23=1;
                }
                break;
            case 38:
                {
                alt23=2;
                }
                break;
            case 39:
                {
                alt23=3;
                }
                break;
            case 40:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:1718:5: lv_name_0_1= 'String'
                    {
                    lv_name_0_1=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getPrimitiveAccess().getNameStringKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1729:5: lv_name_0_2= 'Integer'
                    {
                    lv_name_0_2=(Token)match(input,38,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getPrimitiveAccess().getNameIntegerKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1740:5: lv_name_0_3= 'Boolean'
                    {
                    lv_name_0_3=(Token)match(input,39,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getPrimitiveAccess().getNameBooleanKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1751:5: lv_name_0_4= 'DateTime'
                    {
                    lv_name_0_4=(Token)match(input,40,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getPrimitiveAccess().getNameDateTimeKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getPrimitiveRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitive"


    // $ANTLR start "entryRuleCondition"
    // InternalMyDsl.g:1767:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalMyDsl.g:1767:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalMyDsl.g:1768:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalMyDsl.g:1774:1: ruleCondition returns [EObject current=null] : ( ( ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) ) ) ( (lv_prop_1_0= ruleProposition ) ) otherlv_2= ';' ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token otherlv_2=null;
        EObject lv_prop_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1780:2: ( ( ( ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) ) ) ( (lv_prop_1_0= ruleProposition ) ) otherlv_2= ';' ) )
            // InternalMyDsl.g:1781:2: ( ( ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) ) ) ( (lv_prop_1_0= ruleProposition ) ) otherlv_2= ';' )
            {
            // InternalMyDsl.g:1781:2: ( ( ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) ) ) ( (lv_prop_1_0= ruleProposition ) ) otherlv_2= ';' )
            // InternalMyDsl.g:1782:3: ( ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) ) ) ( (lv_prop_1_0= ruleProposition ) ) otherlv_2= ';'
            {
            // InternalMyDsl.g:1782:3: ( ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) ) )
            // InternalMyDsl.g:1783:4: ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) )
            {
            // InternalMyDsl.g:1783:4: ( (lv_type_0_1= 'pre' | lv_type_0_2= 'post' ) )
            // InternalMyDsl.g:1784:5: (lv_type_0_1= 'pre' | lv_type_0_2= 'post' )
            {
            // InternalMyDsl.g:1784:5: (lv_type_0_1= 'pre' | lv_type_0_2= 'post' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==41) ) {
                alt24=1;
            }
            else if ( (LA24_0==42) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:1785:6: lv_type_0_1= 'pre'
                    {
                    lv_type_0_1=(Token)match(input,41,FOLLOW_35); 

                    						newLeafNode(lv_type_0_1, grammarAccess.getConditionAccess().getTypePreKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConditionRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1796:6: lv_type_0_2= 'post'
                    {
                    lv_type_0_2=(Token)match(input,42,FOLLOW_35); 

                    						newLeafNode(lv_type_0_2, grammarAccess.getConditionAccess().getTypePostKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConditionRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_2, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalMyDsl.g:1809:3: ( (lv_prop_1_0= ruleProposition ) )
            // InternalMyDsl.g:1810:4: (lv_prop_1_0= ruleProposition )
            {
            // InternalMyDsl.g:1810:4: (lv_prop_1_0= ruleProposition )
            // InternalMyDsl.g:1811:5: lv_prop_1_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getPropPropositionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_prop_1_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"prop",
            						lv_prop_1_0,
            						"org.xtext.example.mydsl.MyDsl.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleObligationWrapper"
    // InternalMyDsl.g:1836:1: entryRuleObligationWrapper returns [EObject current=null] : iv_ruleObligationWrapper= ruleObligationWrapper EOF ;
    public final EObject entryRuleObligationWrapper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligationWrapper = null;


        try {
            // InternalMyDsl.g:1836:58: (iv_ruleObligationWrapper= ruleObligationWrapper EOF )
            // InternalMyDsl.g:1837:2: iv_ruleObligationWrapper= ruleObligationWrapper EOF
            {
             newCompositeNode(grammarAccess.getObligationWrapperRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationWrapper=ruleObligationWrapper();

            state._fsp--;

             current =iv_ruleObligationWrapper; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationWrapper"


    // $ANTLR start "ruleObligationWrapper"
    // InternalMyDsl.g:1843:1: ruleObligationWrapper returns [EObject current=null] : ( ( ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_obl_3_0= ruleObligation ) ) otherlv_4= ';' ) ;
    public final EObject ruleObligationWrapper() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_obl_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1849:2: ( ( ( ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_obl_3_0= ruleObligation ) ) otherlv_4= ';' ) )
            // InternalMyDsl.g:1850:2: ( ( ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_obl_3_0= ruleObligation ) ) otherlv_4= ';' )
            {
            // InternalMyDsl.g:1850:2: ( ( ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_obl_3_0= ruleObligation ) ) otherlv_4= ';' )
            // InternalMyDsl.g:1851:3: ( ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_obl_3_0= ruleObligation ) ) otherlv_4= ';'
            {
            // InternalMyDsl.g:1851:3: ( ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) ) )
            // InternalMyDsl.g:1852:4: ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) )
            {
            // InternalMyDsl.g:1852:4: ( (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' ) )
            // InternalMyDsl.g:1853:5: (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' )
            {
            // InternalMyDsl.g:1853:5: (lv_type_0_1= 'obl' | lv_type_0_2= 'sobl' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==43) ) {
                alt25=1;
            }
            else if ( (LA25_0==44) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:1854:6: lv_type_0_1= 'obl'
                    {
                    lv_type_0_1=(Token)match(input,43,FOLLOW_4); 

                    						newLeafNode(lv_type_0_1, grammarAccess.getObligationWrapperAccess().getTypeOblKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getObligationWrapperRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1865:6: lv_type_0_2= 'sobl'
                    {
                    lv_type_0_2=(Token)match(input,44,FOLLOW_4); 

                    						newLeafNode(lv_type_0_2, grammarAccess.getObligationWrapperAccess().getTypeSoblKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getObligationWrapperRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_2, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalMyDsl.g:1878:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1879:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1879:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1880:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getObligationWrapperAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationWrapperRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_36); 

            			newLeafNode(otherlv_2, grammarAccess.getObligationWrapperAccess().getEqualsSignKeyword_2());
            		
            // InternalMyDsl.g:1900:3: ( (lv_obl_3_0= ruleObligation ) )
            // InternalMyDsl.g:1901:4: (lv_obl_3_0= ruleObligation )
            {
            // InternalMyDsl.g:1901:4: (lv_obl_3_0= ruleObligation )
            // InternalMyDsl.g:1902:5: lv_obl_3_0= ruleObligation
            {

            					newCompositeNode(grammarAccess.getObligationWrapperAccess().getOblObligationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_18);
            lv_obl_3_0=ruleObligation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationWrapperRule());
            					}
            					set(
            						current,
            						"obl",
            						lv_obl_3_0,
            						"org.xtext.example.mydsl.MyDsl.Obligation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getObligationWrapperAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationWrapper"


    // $ANTLR start "entryRulePowerWrapper"
    // InternalMyDsl.g:1927:1: entryRulePowerWrapper returns [EObject current=null] : iv_rulePowerWrapper= rulePowerWrapper EOF ;
    public final EObject entryRulePowerWrapper() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerWrapper = null;


        try {
            // InternalMyDsl.g:1927:53: (iv_rulePowerWrapper= rulePowerWrapper EOF )
            // InternalMyDsl.g:1928:2: iv_rulePowerWrapper= rulePowerWrapper EOF
            {
             newCompositeNode(grammarAccess.getPowerWrapperRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerWrapper=rulePowerWrapper();

            state._fsp--;

             current =iv_rulePowerWrapper; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerWrapper"


    // $ANTLR start "rulePowerWrapper"
    // InternalMyDsl.g:1934:1: rulePowerWrapper returns [EObject current=null] : (otherlv_0= 'pow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pow_3_0= rulePower ) ) otherlv_4= ';' ) ;
    public final EObject rulePowerWrapper() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_pow_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1940:2: ( (otherlv_0= 'pow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pow_3_0= rulePower ) ) otherlv_4= ';' ) )
            // InternalMyDsl.g:1941:2: (otherlv_0= 'pow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pow_3_0= rulePower ) ) otherlv_4= ';' )
            {
            // InternalMyDsl.g:1941:2: (otherlv_0= 'pow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pow_3_0= rulePower ) ) otherlv_4= ';' )
            // InternalMyDsl.g:1942:3: otherlv_0= 'pow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pow_3_0= rulePower ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPowerWrapperAccess().getPowKeyword_0());
            		
            // InternalMyDsl.g:1946:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMyDsl.g:1947:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMyDsl.g:1947:4: (lv_name_1_0= RULE_ID )
            // InternalMyDsl.g:1948:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPowerWrapperAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerWrapperRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerWrapperAccess().getEqualsSignKeyword_2());
            		
            // InternalMyDsl.g:1968:3: ( (lv_pow_3_0= rulePower ) )
            // InternalMyDsl.g:1969:4: (lv_pow_3_0= rulePower )
            {
            // InternalMyDsl.g:1969:4: (lv_pow_3_0= rulePower )
            // InternalMyDsl.g:1970:5: lv_pow_3_0= rulePower
            {

            					newCompositeNode(grammarAccess.getPowerWrapperAccess().getPowPowerParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_18);
            lv_pow_3_0=rulePower();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerWrapperRule());
            					}
            					set(
            						current,
            						"pow",
            						lv_pow_3_0,
            						"org.xtext.example.mydsl.MyDsl.Power");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPowerWrapperAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerWrapper"


    // $ANTLR start "entryRuleConstraint"
    // InternalMyDsl.g:1995:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalMyDsl.g:1995:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalMyDsl.g:1996:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalMyDsl.g:2002:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'constr' ( (lv_contsr_1_0= ruleProposition ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_contsr_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2008:2: ( (otherlv_0= 'constr' ( (lv_contsr_1_0= ruleProposition ) ) ) )
            // InternalMyDsl.g:2009:2: (otherlv_0= 'constr' ( (lv_contsr_1_0= ruleProposition ) ) )
            {
            // InternalMyDsl.g:2009:2: (otherlv_0= 'constr' ( (lv_contsr_1_0= ruleProposition ) ) )
            // InternalMyDsl.g:2010:3: otherlv_0= 'constr' ( (lv_contsr_1_0= ruleProposition ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_35); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getConstrKeyword_0());
            		
            // InternalMyDsl.g:2014:3: ( (lv_contsr_1_0= ruleProposition ) )
            // InternalMyDsl.g:2015:4: (lv_contsr_1_0= ruleProposition )
            {
            // InternalMyDsl.g:2015:4: (lv_contsr_1_0= ruleProposition )
            // InternalMyDsl.g:2016:5: lv_contsr_1_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getContsrPropositionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_contsr_1_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"contsr",
            						lv_contsr_1_0,
            						"org.xtext.example.mydsl.MyDsl.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleProposition"
    // InternalMyDsl.g:2037:1: entryRuleProposition returns [EObject current=null] : iv_ruleProposition= ruleProposition EOF ;
    public final EObject entryRuleProposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProposition = null;


        try {
            // InternalMyDsl.g:2037:52: (iv_ruleProposition= ruleProposition EOF )
            // InternalMyDsl.g:2038:2: iv_ruleProposition= ruleProposition EOF
            {
             newCompositeNode(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProposition=ruleProposition();

            state._fsp--;

             current =iv_ruleProposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalMyDsl.g:2044:1: ruleProposition returns [EObject current=null] : this_POr_0= rulePOr ;
    public final EObject ruleProposition() throws RecognitionException {
        EObject current = null;

        EObject this_POr_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2050:2: (this_POr_0= rulePOr )
            // InternalMyDsl.g:2051:2: this_POr_0= rulePOr
            {

            		newCompositeNode(grammarAccess.getPropositionAccess().getPOrParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_POr_0=rulePOr();

            state._fsp--;


            		current = this_POr_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "entryRulePOr"
    // InternalMyDsl.g:2062:1: entryRulePOr returns [EObject current=null] : iv_rulePOr= rulePOr EOF ;
    public final EObject entryRulePOr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePOr = null;


        try {
            // InternalMyDsl.g:2062:44: (iv_rulePOr= rulePOr EOF )
            // InternalMyDsl.g:2063:2: iv_rulePOr= rulePOr EOF
            {
             newCompositeNode(grammarAccess.getPOrRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePOr=rulePOr();

            state._fsp--;

             current =iv_rulePOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePOr"


    // $ANTLR start "rulePOr"
    // InternalMyDsl.g:2069:1: rulePOr returns [EObject current=null] : (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* ) ;
    public final EObject rulePOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PAnd_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2075:2: ( (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* ) )
            // InternalMyDsl.g:2076:2: (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* )
            {
            // InternalMyDsl.g:2076:2: (this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )* )
            // InternalMyDsl.g:2077:3: this_PAnd_0= rulePAnd ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getPOrAccess().getPAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_38);
            this_PAnd_0=rulePAnd();

            state._fsp--;


            			current = this_PAnd_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:2085:3: ( () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==47) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalMyDsl.g:2086:4: () otherlv_2= 'or' ( (lv_right_3_0= rulePAnd ) )
            	    {
            	    // InternalMyDsl.g:2086:4: ()
            	    // InternalMyDsl.g:2087:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPOrAccess().getPOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,47,FOLLOW_35); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalMyDsl.g:2097:4: ( (lv_right_3_0= rulePAnd ) )
            	    // InternalMyDsl.g:2098:5: (lv_right_3_0= rulePAnd )
            	    {
            	    // InternalMyDsl.g:2098:5: (lv_right_3_0= rulePAnd )
            	    // InternalMyDsl.g:2099:6: lv_right_3_0= rulePAnd
            	    {

            	    						newCompositeNode(grammarAccess.getPOrAccess().getRightPAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_38);
            	    lv_right_3_0=rulePAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.PAnd");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePOr"


    // $ANTLR start "entryRulePAnd"
    // InternalMyDsl.g:2121:1: entryRulePAnd returns [EObject current=null] : iv_rulePAnd= rulePAnd EOF ;
    public final EObject entryRulePAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAnd = null;


        try {
            // InternalMyDsl.g:2121:45: (iv_rulePAnd= rulePAnd EOF )
            // InternalMyDsl.g:2122:2: iv_rulePAnd= rulePAnd EOF
            {
             newCompositeNode(grammarAccess.getPAndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePAnd=rulePAnd();

            state._fsp--;

             current =iv_rulePAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAnd"


    // $ANTLR start "rulePAnd"
    // InternalMyDsl.g:2128:1: rulePAnd returns [EObject current=null] : (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* ) ;
    public final EObject rulePAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PEquality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2134:2: ( (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* ) )
            // InternalMyDsl.g:2135:2: (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* )
            {
            // InternalMyDsl.g:2135:2: (this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )* )
            // InternalMyDsl.g:2136:3: this_PEquality_0= rulePEquality ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )*
            {

            			newCompositeNode(grammarAccess.getPAndAccess().getPEqualityParserRuleCall_0());
            		
            pushFollow(FOLLOW_39);
            this_PEquality_0=rulePEquality();

            state._fsp--;


            			current = this_PEquality_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:2144:3: ( () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==48) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMyDsl.g:2145:4: () otherlv_2= 'and' ( (lv_right_3_0= rulePEquality ) )
            	    {
            	    // InternalMyDsl.g:2145:4: ()
            	    // InternalMyDsl.g:2146:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPAndAccess().getPAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,48,FOLLOW_35); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalMyDsl.g:2156:4: ( (lv_right_3_0= rulePEquality ) )
            	    // InternalMyDsl.g:2157:5: (lv_right_3_0= rulePEquality )
            	    {
            	    // InternalMyDsl.g:2157:5: (lv_right_3_0= rulePEquality )
            	    // InternalMyDsl.g:2158:6: lv_right_3_0= rulePEquality
            	    {

            	    						newCompositeNode(grammarAccess.getPAndAccess().getRightPEqualityParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=rulePEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.PEquality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePAnd"


    // $ANTLR start "entryRulePEquality"
    // InternalMyDsl.g:2180:1: entryRulePEquality returns [EObject current=null] : iv_rulePEquality= rulePEquality EOF ;
    public final EObject entryRulePEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePEquality = null;


        try {
            // InternalMyDsl.g:2180:50: (iv_rulePEquality= rulePEquality EOF )
            // InternalMyDsl.g:2181:2: iv_rulePEquality= rulePEquality EOF
            {
             newCompositeNode(grammarAccess.getPEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePEquality=rulePEquality();

            state._fsp--;

             current =iv_rulePEquality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePEquality"


    // $ANTLR start "rulePEquality"
    // InternalMyDsl.g:2187:1: rulePEquality returns [EObject current=null] : (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* ) ;
    public final EObject rulePEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_PComparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2193:2: ( (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* ) )
            // InternalMyDsl.g:2194:2: (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* )
            {
            // InternalMyDsl.g:2194:2: (this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )* )
            // InternalMyDsl.g:2195:3: this_PComparison_0= rulePComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )*
            {

            			newCompositeNode(grammarAccess.getPEqualityAccess().getPComparisonParserRuleCall_0());
            		
            pushFollow(FOLLOW_40);
            this_PComparison_0=rulePComparison();

            state._fsp--;


            			current = this_PComparison_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:2203:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=49 && LA29_0<=50)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalMyDsl.g:2204:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= rulePComparison ) )
            	    {
            	    // InternalMyDsl.g:2204:4: ()
            	    // InternalMyDsl.g:2205:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPEqualityAccess().getPEqualityLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMyDsl.g:2211:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalMyDsl.g:2212:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalMyDsl.g:2212:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalMyDsl.g:2213:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalMyDsl.g:2213:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==49) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==50) ) {
            	        alt28=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // InternalMyDsl.g:2214:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,49,FOLLOW_35); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getPEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:2225:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,50,FOLLOW_35); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getPEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyDsl.g:2238:4: ( (lv_right_3_0= rulePComparison ) )
            	    // InternalMyDsl.g:2239:5: (lv_right_3_0= rulePComparison )
            	    {
            	    // InternalMyDsl.g:2239:5: (lv_right_3_0= rulePComparison )
            	    // InternalMyDsl.g:2240:6: lv_right_3_0= rulePComparison
            	    {

            	    						newCompositeNode(grammarAccess.getPEqualityAccess().getRightPComparisonParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=rulePComparison();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.PComparison");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePEquality"


    // $ANTLR start "entryRulePComparison"
    // InternalMyDsl.g:2262:1: entryRulePComparison returns [EObject current=null] : iv_rulePComparison= rulePComparison EOF ;
    public final EObject entryRulePComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePComparison = null;


        try {
            // InternalMyDsl.g:2262:52: (iv_rulePComparison= rulePComparison EOF )
            // InternalMyDsl.g:2263:2: iv_rulePComparison= rulePComparison EOF
            {
             newCompositeNode(grammarAccess.getPComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePComparison=rulePComparison();

            state._fsp--;

             current =iv_rulePComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePComparison"


    // $ANTLR start "rulePComparison"
    // InternalMyDsl.g:2269:1: rulePComparison returns [EObject current=null] : (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* ) ;
    public final EObject rulePComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_PAtomicExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2275:2: ( (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* ) )
            // InternalMyDsl.g:2276:2: (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* )
            {
            // InternalMyDsl.g:2276:2: (this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )* )
            // InternalMyDsl.g:2277:3: this_PAtomicExpression_0= rulePAtomicExpression ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getPComparisonAccess().getPAtomicExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_41);
            this_PAtomicExpression_0=rulePAtomicExpression();

            state._fsp--;


            			current = this_PAtomicExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:2285:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=51 && LA31_0<=54)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMyDsl.g:2286:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePAtomicExpression ) )
            	    {
            	    // InternalMyDsl.g:2286:4: ()
            	    // InternalMyDsl.g:2287:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getPComparisonAccess().getPComparisonLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMyDsl.g:2293:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalMyDsl.g:2294:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalMyDsl.g:2294:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalMyDsl.g:2295:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalMyDsl.g:2295:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt30=4;
            	    switch ( input.LA(1) ) {
            	    case 51:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case 52:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case 53:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // InternalMyDsl.g:2296:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,51,FOLLOW_35); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getPComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:2307:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,52,FOLLOW_35); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getPComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalMyDsl.g:2318:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,53,FOLLOW_35); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getPComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalMyDsl.g:2329:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,54,FOLLOW_35); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getPComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getPComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyDsl.g:2342:4: ( (lv_right_3_0= rulePAtomicExpression ) )
            	    // InternalMyDsl.g:2343:5: (lv_right_3_0= rulePAtomicExpression )
            	    {
            	    // InternalMyDsl.g:2343:5: (lv_right_3_0= rulePAtomicExpression )
            	    // InternalMyDsl.g:2344:6: lv_right_3_0= rulePAtomicExpression
            	    {

            	    						newCompositeNode(grammarAccess.getPComparisonAccess().getRightPAtomicExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_right_3_0=rulePAtomicExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPComparisonRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.PAtomicExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePComparison"


    // $ANTLR start "entryRulePAtomicExpression"
    // InternalMyDsl.g:2366:1: entryRulePAtomicExpression returns [EObject current=null] : iv_rulePAtomicExpression= rulePAtomicExpression EOF ;
    public final EObject entryRulePAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAtomicExpression = null;


        try {
            // InternalMyDsl.g:2366:58: (iv_rulePAtomicExpression= rulePAtomicExpression EOF )
            // InternalMyDsl.g:2367:2: iv_rulePAtomicExpression= rulePAtomicExpression EOF
            {
             newCompositeNode(grammarAccess.getPAtomicExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePAtomicExpression=rulePAtomicExpression();

            state._fsp--;

             current =iv_rulePAtomicExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAtomicExpression"


    // $ANTLR start "rulePAtomicExpression"
    // InternalMyDsl.g:2373:1: rulePAtomicExpression returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) ) ;
    public final EObject rulePAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_enumeration_12_0=null;
        Token otherlv_13=null;
        Token lv_enumItem_14_0=null;
        Token otherlv_15=null;
        Token lv_value_19_0=null;
        Token lv_value_21_0=null;
        Token lv_value_25_0=null;
        Token lv_value_27_0=null;
        EObject lv_inner_2_0 = null;

        EObject lv_negated_6_0 = null;

        EObject lv_predicateFunction_8_0 = null;

        EObject lv_function_10_0 = null;

        EObject lv_variable_17_0 = null;

        AntlrDatatypeRuleToken lv_value_23_0 = null;

        AntlrDatatypeRuleToken lv_value_29_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2379:2: ( ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) ) )
            // InternalMyDsl.g:2380:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )
            {
            // InternalMyDsl.g:2380:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )
            int alt32=12;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:2381:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' )
                    {
                    // InternalMyDsl.g:2381:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' )
                    // InternalMyDsl.g:2382:4: () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')'
                    {
                    // InternalMyDsl.g:2382:4: ()
                    // InternalMyDsl.g:2383:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomRecursiveAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,20,FOLLOW_35); 

                    				newLeafNode(otherlv_1, grammarAccess.getPAtomicExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalMyDsl.g:2393:4: ( (lv_inner_2_0= ruleProposition ) )
                    // InternalMyDsl.g:2394:5: (lv_inner_2_0= ruleProposition )
                    {
                    // InternalMyDsl.g:2394:5: (lv_inner_2_0= ruleProposition )
                    // InternalMyDsl.g:2395:6: lv_inner_2_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getInnerPropositionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_inner_2_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"inner",
                    							lv_inner_2_0,
                    							"org.xtext.example.mydsl.MyDsl.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPAtomicExpressionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2418:3: ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) )
                    {
                    // InternalMyDsl.g:2418:3: ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) )
                    // InternalMyDsl.g:2419:4: () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) )
                    {
                    // InternalMyDsl.g:2419:4: ()
                    // InternalMyDsl.g:2420:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getNegatedPAtomAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_5=(Token)match(input,55,FOLLOW_35); 

                    				newLeafNode(otherlv_5, grammarAccess.getPAtomicExpressionAccess().getNotKeyword_1_1());
                    			
                    // InternalMyDsl.g:2430:4: ( (lv_negated_6_0= rulePAtomicExpression ) )
                    // InternalMyDsl.g:2431:5: (lv_negated_6_0= rulePAtomicExpression )
                    {
                    // InternalMyDsl.g:2431:5: (lv_negated_6_0= rulePAtomicExpression )
                    // InternalMyDsl.g:2432:6: lv_negated_6_0= rulePAtomicExpression
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getNegatedPAtomicExpressionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_negated_6_0=rulePAtomicExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"negated",
                    							lv_negated_6_0,
                    							"org.xtext.example.mydsl.MyDsl.PAtomicExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2451:3: ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) )
                    {
                    // InternalMyDsl.g:2451:3: ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) )
                    // InternalMyDsl.g:2452:4: () ( (lv_predicateFunction_8_0= rulePredicateFunction ) )
                    {
                    // InternalMyDsl.g:2452:4: ()
                    // InternalMyDsl.g:2453:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2459:4: ( (lv_predicateFunction_8_0= rulePredicateFunction ) )
                    // InternalMyDsl.g:2460:5: (lv_predicateFunction_8_0= rulePredicateFunction )
                    {
                    // InternalMyDsl.g:2460:5: (lv_predicateFunction_8_0= rulePredicateFunction )
                    // InternalMyDsl.g:2461:6: lv_predicateFunction_8_0= rulePredicateFunction
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getPredicateFunctionPredicateFunctionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_predicateFunction_8_0=rulePredicateFunction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"predicateFunction",
                    							lv_predicateFunction_8_0,
                    							"org.xtext.example.mydsl.MyDsl.PredicateFunction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:2480:3: ( () ( (lv_function_10_0= ruleOtherFunction ) ) )
                    {
                    // InternalMyDsl.g:2480:3: ( () ( (lv_function_10_0= ruleOtherFunction ) ) )
                    // InternalMyDsl.g:2481:4: () ( (lv_function_10_0= ruleOtherFunction ) )
                    {
                    // InternalMyDsl.g:2481:4: ()
                    // InternalMyDsl.g:2482:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomFunctionAction_3_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2488:4: ( (lv_function_10_0= ruleOtherFunction ) )
                    // InternalMyDsl.g:2489:5: (lv_function_10_0= ruleOtherFunction )
                    {
                    // InternalMyDsl.g:2489:5: (lv_function_10_0= ruleOtherFunction )
                    // InternalMyDsl.g:2490:6: lv_function_10_0= ruleOtherFunction
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getFunctionOtherFunctionParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_function_10_0=ruleOtherFunction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"function",
                    							lv_function_10_0,
                    							"org.xtext.example.mydsl.MyDsl.OtherFunction");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:2509:3: ( () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')' )
                    {
                    // InternalMyDsl.g:2509:3: ( () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')' )
                    // InternalMyDsl.g:2510:4: () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')'
                    {
                    // InternalMyDsl.g:2510:4: ()
                    // InternalMyDsl.g:2511:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomEnumAction_4_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2517:4: ( (lv_enumeration_12_0= RULE_ID ) )
                    // InternalMyDsl.g:2518:5: (lv_enumeration_12_0= RULE_ID )
                    {
                    // InternalMyDsl.g:2518:5: (lv_enumeration_12_0= RULE_ID )
                    // InternalMyDsl.g:2519:6: lv_enumeration_12_0= RULE_ID
                    {
                    lv_enumeration_12_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_enumeration_12_0, grammarAccess.getPAtomicExpressionAccess().getEnumerationIDTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"enumeration",
                    							lv_enumeration_12_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_13, grammarAccess.getPAtomicExpressionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    // InternalMyDsl.g:2539:4: ( (lv_enumItem_14_0= RULE_ID ) )
                    // InternalMyDsl.g:2540:5: (lv_enumItem_14_0= RULE_ID )
                    {
                    // InternalMyDsl.g:2540:5: (lv_enumItem_14_0= RULE_ID )
                    // InternalMyDsl.g:2541:6: lv_enumItem_14_0= RULE_ID
                    {
                    lv_enumItem_14_0=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(lv_enumItem_14_0, grammarAccess.getPAtomicExpressionAccess().getEnumItemIDTerminalRuleCall_4_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"enumItem",
                    							lv_enumItem_14_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getPAtomicExpressionAccess().getRightParenthesisKeyword_4_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:2563:3: ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalMyDsl.g:2563:3: ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) )
                    // InternalMyDsl.g:2564:4: () ( (lv_variable_17_0= ruleVariableDotExpression ) )
                    {
                    // InternalMyDsl.g:2564:4: ()
                    // InternalMyDsl.g:2565:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomVariableAction_5_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2571:4: ( (lv_variable_17_0= ruleVariableDotExpression ) )
                    // InternalMyDsl.g:2572:5: (lv_variable_17_0= ruleVariableDotExpression )
                    {
                    // InternalMyDsl.g:2572:5: (lv_variable_17_0= ruleVariableDotExpression )
                    // InternalMyDsl.g:2573:6: lv_variable_17_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getVariableVariableDotExpressionParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_17_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_17_0,
                    							"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:2592:3: ( () ( (lv_value_19_0= 'true' ) ) )
                    {
                    // InternalMyDsl.g:2592:3: ( () ( (lv_value_19_0= 'true' ) ) )
                    // InternalMyDsl.g:2593:4: () ( (lv_value_19_0= 'true' ) )
                    {
                    // InternalMyDsl.g:2593:4: ()
                    // InternalMyDsl.g:2594:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateTrueLiteralAction_6_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2600:4: ( (lv_value_19_0= 'true' ) )
                    // InternalMyDsl.g:2601:5: (lv_value_19_0= 'true' )
                    {
                    // InternalMyDsl.g:2601:5: (lv_value_19_0= 'true' )
                    // InternalMyDsl.g:2602:6: lv_value_19_0= 'true'
                    {
                    lv_value_19_0=(Token)match(input,56,FOLLOW_2); 

                    						newLeafNode(lv_value_19_0, grammarAccess.getPAtomicExpressionAccess().getValueTrueKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_19_0, "true");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:2616:3: ( () ( (lv_value_21_0= 'false' ) ) )
                    {
                    // InternalMyDsl.g:2616:3: ( () ( (lv_value_21_0= 'false' ) ) )
                    // InternalMyDsl.g:2617:4: () ( (lv_value_21_0= 'false' ) )
                    {
                    // InternalMyDsl.g:2617:4: ()
                    // InternalMyDsl.g:2618:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomPredicateFalseLiteralAction_7_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2624:4: ( (lv_value_21_0= 'false' ) )
                    // InternalMyDsl.g:2625:5: (lv_value_21_0= 'false' )
                    {
                    // InternalMyDsl.g:2625:5: (lv_value_21_0= 'false' )
                    // InternalMyDsl.g:2626:6: lv_value_21_0= 'false'
                    {
                    lv_value_21_0=(Token)match(input,57,FOLLOW_2); 

                    						newLeafNode(lv_value_21_0, grammarAccess.getPAtomicExpressionAccess().getValueFalseKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_21_0, "false");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:2640:3: ( () ( (lv_value_23_0= ruleDouble ) ) )
                    {
                    // InternalMyDsl.g:2640:3: ( () ( (lv_value_23_0= ruleDouble ) ) )
                    // InternalMyDsl.g:2641:4: () ( (lv_value_23_0= ruleDouble ) )
                    {
                    // InternalMyDsl.g:2641:4: ()
                    // InternalMyDsl.g:2642:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomDoubleLiteralAction_8_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2648:4: ( (lv_value_23_0= ruleDouble ) )
                    // InternalMyDsl.g:2649:5: (lv_value_23_0= ruleDouble )
                    {
                    // InternalMyDsl.g:2649:5: (lv_value_23_0= ruleDouble )
                    // InternalMyDsl.g:2650:6: lv_value_23_0= ruleDouble
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getValueDoubleParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_23_0=ruleDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_23_0,
                    							"org.xtext.example.mydsl.MyDsl.Double");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:2669:3: ( () ( (lv_value_25_0= RULE_INT ) ) )
                    {
                    // InternalMyDsl.g:2669:3: ( () ( (lv_value_25_0= RULE_INT ) ) )
                    // InternalMyDsl.g:2670:4: () ( (lv_value_25_0= RULE_INT ) )
                    {
                    // InternalMyDsl.g:2670:4: ()
                    // InternalMyDsl.g:2671:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomIntLiteralAction_9_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2677:4: ( (lv_value_25_0= RULE_INT ) )
                    // InternalMyDsl.g:2678:5: (lv_value_25_0= RULE_INT )
                    {
                    // InternalMyDsl.g:2678:5: (lv_value_25_0= RULE_INT )
                    // InternalMyDsl.g:2679:6: lv_value_25_0= RULE_INT
                    {
                    lv_value_25_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_25_0, grammarAccess.getPAtomicExpressionAccess().getValueINTTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_25_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:2697:3: ( () ( (lv_value_27_0= RULE_STRING ) ) )
                    {
                    // InternalMyDsl.g:2697:3: ( () ( (lv_value_27_0= RULE_STRING ) ) )
                    // InternalMyDsl.g:2698:4: () ( (lv_value_27_0= RULE_STRING ) )
                    {
                    // InternalMyDsl.g:2698:4: ()
                    // InternalMyDsl.g:2699:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomStringLiteralAction_10_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2705:4: ( (lv_value_27_0= RULE_STRING ) )
                    // InternalMyDsl.g:2706:5: (lv_value_27_0= RULE_STRING )
                    {
                    // InternalMyDsl.g:2706:5: (lv_value_27_0= RULE_STRING )
                    // InternalMyDsl.g:2707:6: lv_value_27_0= RULE_STRING
                    {
                    lv_value_27_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_27_0, grammarAccess.getPAtomicExpressionAccess().getValueSTRINGTerminalRuleCall_10_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_27_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:2725:3: ( () ( (lv_value_29_0= ruleDate ) ) )
                    {
                    // InternalMyDsl.g:2725:3: ( () ( (lv_value_29_0= ruleDate ) ) )
                    // InternalMyDsl.g:2726:4: () ( (lv_value_29_0= ruleDate ) )
                    {
                    // InternalMyDsl.g:2726:4: ()
                    // InternalMyDsl.g:2727:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPAtomicExpressionAccess().getPAtomDateLiteralAction_11_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2733:4: ( (lv_value_29_0= ruleDate ) )
                    // InternalMyDsl.g:2734:5: (lv_value_29_0= ruleDate )
                    {
                    // InternalMyDsl.g:2734:5: (lv_value_29_0= ruleDate )
                    // InternalMyDsl.g:2735:6: lv_value_29_0= ruleDate
                    {

                    						newCompositeNode(grammarAccess.getPAtomicExpressionAccess().getValueDateParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_29_0=ruleDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_29_0,
                    							"org.xtext.example.mydsl.MyDsl.Date");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePAtomicExpression"


    // $ANTLR start "entryRuleOtherFunction"
    // InternalMyDsl.g:2757:1: entryRuleOtherFunction returns [EObject current=null] : iv_ruleOtherFunction= ruleOtherFunction EOF ;
    public final EObject entryRuleOtherFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherFunction = null;


        try {
            // InternalMyDsl.g:2757:54: (iv_ruleOtherFunction= ruleOtherFunction EOF )
            // InternalMyDsl.g:2758:2: iv_ruleOtherFunction= ruleOtherFunction EOF
            {
             newCompositeNode(grammarAccess.getOtherFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherFunction=ruleOtherFunction();

            state._fsp--;

             current =iv_ruleOtherFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherFunction"


    // $ANTLR start "ruleOtherFunction"
    // InternalMyDsl.g:2764:1: ruleOtherFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) ) ;
    public final EObject ruleOtherFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_arg1_3_0=null;
        Token otherlv_4=null;
        Token lv_arg2_5_0=null;
        Token otherlv_6=null;
        Token lv_name_8_0=null;
        Token otherlv_9=null;
        Token lv_arg1_10_0=null;
        Token otherlv_11=null;
        Token lv_arg2_12_0=null;
        Token otherlv_13=null;
        Token lv_name_15_0=null;
        Token otherlv_16=null;
        Token lv_arg1_17_0=null;
        Token otherlv_18=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2770:2: ( ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) ) )
            // InternalMyDsl.g:2771:2: ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) )
            {
            // InternalMyDsl.g:2771:2: ( ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' ) | ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' ) | ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' ) )
            int alt33=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt33=1;
                }
                break;
            case 59:
                {
                alt33=2;
                }
                break;
            case 60:
                {
                alt33=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalMyDsl.g:2772:3: ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' )
                    {
                    // InternalMyDsl.g:2772:3: ( () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')' )
                    // InternalMyDsl.g:2773:4: () ( (lv_name_1_0= 'IsEqual' ) ) otherlv_2= '(' ( (lv_arg1_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_arg2_5_0= RULE_ID ) ) otherlv_6= ')'
                    {
                    // InternalMyDsl.g:2773:4: ()
                    // InternalMyDsl.g:2774:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionIsEqualAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2780:4: ( (lv_name_1_0= 'IsEqual' ) )
                    // InternalMyDsl.g:2781:5: (lv_name_1_0= 'IsEqual' )
                    {
                    // InternalMyDsl.g:2781:5: (lv_name_1_0= 'IsEqual' )
                    // InternalMyDsl.g:2782:6: lv_name_1_0= 'IsEqual'
                    {
                    lv_name_1_0=(Token)match(input,58,FOLLOW_12); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getOtherFunctionAccess().getNameIsEqualKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "IsEqual");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalMyDsl.g:2798:4: ( (lv_arg1_3_0= RULE_ID ) )
                    // InternalMyDsl.g:2799:5: (lv_arg1_3_0= RULE_ID )
                    {
                    // InternalMyDsl.g:2799:5: (lv_arg1_3_0= RULE_ID )
                    // InternalMyDsl.g:2800:6: lv_arg1_3_0= RULE_ID
                    {
                    lv_arg1_3_0=(Token)match(input,RULE_ID,FOLLOW_43); 

                    						newLeafNode(lv_arg1_3_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_0_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,21,FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getOtherFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalMyDsl.g:2820:4: ( (lv_arg2_5_0= RULE_ID ) )
                    // InternalMyDsl.g:2821:5: (lv_arg2_5_0= RULE_ID )
                    {
                    // InternalMyDsl.g:2821:5: (lv_arg2_5_0= RULE_ID )
                    // InternalMyDsl.g:2822:6: lv_arg2_5_0= RULE_ID
                    {
                    lv_arg2_5_0=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(lv_arg2_5_0, grammarAccess.getOtherFunctionAccess().getArg2IDTerminalRuleCall_0_5_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:2844:3: ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' )
                    {
                    // InternalMyDsl.g:2844:3: ( () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')' )
                    // InternalMyDsl.g:2845:4: () ( (lv_name_8_0= 'IsOwner' ) ) otherlv_9= '(' ( (lv_arg1_10_0= RULE_ID ) ) otherlv_11= ',' ( (lv_arg2_12_0= RULE_ID ) ) otherlv_13= ')'
                    {
                    // InternalMyDsl.g:2845:4: ()
                    // InternalMyDsl.g:2846:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionIsOwnerAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2852:4: ( (lv_name_8_0= 'IsOwner' ) )
                    // InternalMyDsl.g:2853:5: (lv_name_8_0= 'IsOwner' )
                    {
                    // InternalMyDsl.g:2853:5: (lv_name_8_0= 'IsOwner' )
                    // InternalMyDsl.g:2854:6: lv_name_8_0= 'IsOwner'
                    {
                    lv_name_8_0=(Token)match(input,59,FOLLOW_12); 

                    						newLeafNode(lv_name_8_0, grammarAccess.getOtherFunctionAccess().getNameIsOwnerKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_8_0, "IsOwner");
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMyDsl.g:2870:4: ( (lv_arg1_10_0= RULE_ID ) )
                    // InternalMyDsl.g:2871:5: (lv_arg1_10_0= RULE_ID )
                    {
                    // InternalMyDsl.g:2871:5: (lv_arg1_10_0= RULE_ID )
                    // InternalMyDsl.g:2872:6: lv_arg1_10_0= RULE_ID
                    {
                    lv_arg1_10_0=(Token)match(input,RULE_ID,FOLLOW_43); 

                    						newLeafNode(lv_arg1_10_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_1_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_10_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,21,FOLLOW_4); 

                    				newLeafNode(otherlv_11, grammarAccess.getOtherFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalMyDsl.g:2892:4: ( (lv_arg2_12_0= RULE_ID ) )
                    // InternalMyDsl.g:2893:5: (lv_arg2_12_0= RULE_ID )
                    {
                    // InternalMyDsl.g:2893:5: (lv_arg2_12_0= RULE_ID )
                    // InternalMyDsl.g:2894:6: lv_arg2_12_0= RULE_ID
                    {
                    lv_arg2_12_0=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(lv_arg2_12_0, grammarAccess.getOtherFunctionAccess().getArg2IDTerminalRuleCall_1_5_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg2",
                    							lv_arg2_12_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:2916:3: ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' )
                    {
                    // InternalMyDsl.g:2916:3: ( () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')' )
                    // InternalMyDsl.g:2917:4: () ( (lv_name_15_0= 'CannotBeAssigned' ) ) otherlv_16= '(' ( (lv_arg1_17_0= RULE_ID ) ) otherlv_18= ')'
                    {
                    // InternalMyDsl.g:2917:4: ()
                    // InternalMyDsl.g:2918:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOtherFunctionAccess().getPredicateFunctionCannotBeAssignedAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:2924:4: ( (lv_name_15_0= 'CannotBeAssigned' ) )
                    // InternalMyDsl.g:2925:5: (lv_name_15_0= 'CannotBeAssigned' )
                    {
                    // InternalMyDsl.g:2925:5: (lv_name_15_0= 'CannotBeAssigned' )
                    // InternalMyDsl.g:2926:6: lv_name_15_0= 'CannotBeAssigned'
                    {
                    lv_name_15_0=(Token)match(input,60,FOLLOW_12); 

                    						newLeafNode(lv_name_15_0, grammarAccess.getOtherFunctionAccess().getNameCannotBeAssignedKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_15_0, "CannotBeAssigned");
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_16, grammarAccess.getOtherFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMyDsl.g:2942:4: ( (lv_arg1_17_0= RULE_ID ) )
                    // InternalMyDsl.g:2943:5: (lv_arg1_17_0= RULE_ID )
                    {
                    // InternalMyDsl.g:2943:5: (lv_arg1_17_0= RULE_ID )
                    // InternalMyDsl.g:2944:6: lv_arg1_17_0= RULE_ID
                    {
                    lv_arg1_17_0=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(lv_arg1_17_0, grammarAccess.getOtherFunctionAccess().getArg1IDTerminalRuleCall_2_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOtherFunctionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"arg1",
                    							lv_arg1_17_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getOtherFunctionAccess().getRightParenthesisKeyword_2_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherFunction"


    // $ANTLR start "entryRuleDouble"
    // InternalMyDsl.g:2969:1: entryRuleDouble returns [String current=null] : iv_ruleDouble= ruleDouble EOF ;
    public final String entryRuleDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble = null;


        try {
            // InternalMyDsl.g:2969:46: (iv_ruleDouble= ruleDouble EOF )
            // InternalMyDsl.g:2970:2: iv_ruleDouble= ruleDouble EOF
            {
             newCompositeNode(grammarAccess.getDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDouble=ruleDouble();

            state._fsp--;

             current =iv_ruleDouble.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // InternalMyDsl.g:2976:1: ruleDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:2982:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalMyDsl.g:2983:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalMyDsl.g:2983:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalMyDsl.g:2984:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_44); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,16,FOLLOW_45); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDoubleAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDoubleAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDouble"


    // $ANTLR start "entryRuleDate"
    // InternalMyDsl.g:3007:1: entryRuleDate returns [String current=null] : iv_ruleDate= ruleDate EOF ;
    public final String entryRuleDate() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDate = null;


        try {
            // InternalMyDsl.g:3007:44: (iv_ruleDate= ruleDate EOF )
            // InternalMyDsl.g:3008:2: iv_ruleDate= ruleDate EOF
            {
             newCompositeNode(grammarAccess.getDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDate=ruleDate();

            state._fsp--;

             current =iv_ruleDate.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDate"


    // $ANTLR start "ruleDate"
    // InternalMyDsl.g:3014:1: ruleDate returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleDate() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3020:2: ( (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' ) )
            // InternalMyDsl.g:3021:2: (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' )
            {
            // InternalMyDsl.g:3021:2: (kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')' )
            // InternalMyDsl.g:3022:3: kw= 'Date' kw= '(' this_STRING_2= RULE_STRING kw= ')'
            {
            kw=(Token)match(input,61,FOLLOW_12); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getDateKeyword_0());
            		
            kw=(Token)match(input,20,FOLLOW_46); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getLeftParenthesisKeyword_1());
            		
            this_STRING_2=(Token)match(input,RULE_STRING,FOLLOW_42); 

            			current.merge(this_STRING_2);
            		

            			newLeafNode(this_STRING_2, grammarAccess.getDateAccess().getSTRINGTerminalRuleCall_2());
            		
            kw=(Token)match(input,22,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDate"


    // $ANTLR start "entryRulePredicateFunction"
    // InternalMyDsl.g:3048:1: entryRulePredicateFunction returns [EObject current=null] : iv_rulePredicateFunction= rulePredicateFunction EOF ;
    public final EObject entryRulePredicateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateFunction = null;


        try {
            // InternalMyDsl.g:3048:58: (iv_rulePredicateFunction= rulePredicateFunction EOF )
            // InternalMyDsl.g:3049:2: iv_rulePredicateFunction= rulePredicateFunction EOF
            {
             newCompositeNode(grammarAccess.getPredicateFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePredicateFunction=rulePredicateFunction();

            state._fsp--;

             current =iv_rulePredicateFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicateFunction"


    // $ANTLR start "rulePredicateFunction"
    // InternalMyDsl.g:3055:1: rulePredicateFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) ) ;
    public final EObject rulePredicateFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_name_13_0=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token lv_name_20_0=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token lv_name_27_0=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token lv_name_34_0=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token lv_name_41_0=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token lv_name_48_0=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        EObject lv_event_3_0 = null;

        EObject lv_event_8_0 = null;

        EObject lv_point_10_0 = null;

        EObject lv_event_15_0 = null;

        EObject lv_point_17_0 = null;

        EObject lv_event_22_0 = null;

        EObject lv_interval_24_0 = null;

        EObject lv_event1_29_0 = null;

        EObject lv_event2_31_0 = null;

        EObject lv_event1_36_0 = null;

        EObject lv_event2_38_0 = null;

        EObject lv_event_43_0 = null;

        EObject lv_point_45_0 = null;

        EObject lv_situation_50_0 = null;

        EObject lv_interval_52_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3061:2: ( ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) ) )
            // InternalMyDsl.g:3062:2: ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) )
            {
            // InternalMyDsl.g:3062:2: ( ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' ) | ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' ) | ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' ) | ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' ) | ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' ) | ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' ) | ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' ) | ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' ) )
            int alt34=8;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt34=1;
                }
                break;
            case 63:
                {
                alt34=2;
                }
                break;
            case 64:
                {
                alt34=3;
                }
                break;
            case 65:
                {
                alt34=4;
                }
                break;
            case 66:
                {
                alt34=5;
                }
                break;
            case 67:
                {
                alt34=6;
                }
                break;
            case 68:
                {
                alt34=7;
                }
                break;
            case 69:
                {
                alt34=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalMyDsl.g:3063:3: ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' )
                    {
                    // InternalMyDsl.g:3063:3: ( () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')' )
                    // InternalMyDsl.g:3064:4: () ( (lv_name_1_0= 'Happens' ) ) otherlv_2= '(' ( (lv_event_3_0= ruleEvent ) ) otherlv_4= ')'
                    {
                    // InternalMyDsl.g:3064:4: ()
                    // InternalMyDsl.g:3065:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3071:4: ( (lv_name_1_0= 'Happens' ) )
                    // InternalMyDsl.g:3072:5: (lv_name_1_0= 'Happens' )
                    {
                    // InternalMyDsl.g:3072:5: (lv_name_1_0= 'Happens' )
                    // InternalMyDsl.g:3073:6: lv_name_1_0= 'Happens'
                    {
                    lv_name_1_0=(Token)match(input,62,FOLLOW_12); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getPredicateFunctionAccess().getNameHappensKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "Happens");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_2, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalMyDsl.g:3089:4: ( (lv_event_3_0= ruleEvent ) )
                    // InternalMyDsl.g:3090:5: (lv_event_3_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3090:5: (lv_event_3_0= ruleEvent )
                    // InternalMyDsl.g:3091:6: lv_event_3_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_event_3_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_3_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_0_4());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3114:3: ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' )
                    {
                    // InternalMyDsl.g:3114:3: ( () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')' )
                    // InternalMyDsl.g:3115:4: () ( (lv_name_6_0= 'WhappensBefore' ) ) otherlv_7= '(' ( (lv_event_8_0= ruleEvent ) ) otherlv_9= ',' ( (lv_point_10_0= rulePoint ) ) otherlv_11= ')'
                    {
                    // InternalMyDsl.g:3115:4: ()
                    // InternalMyDsl.g:3116:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionWHappensBeforeAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3122:4: ( (lv_name_6_0= 'WhappensBefore' ) )
                    // InternalMyDsl.g:3123:5: (lv_name_6_0= 'WhappensBefore' )
                    {
                    // InternalMyDsl.g:3123:5: (lv_name_6_0= 'WhappensBefore' )
                    // InternalMyDsl.g:3124:6: lv_name_6_0= 'WhappensBefore'
                    {
                    lv_name_6_0=(Token)match(input,63,FOLLOW_12); 

                    						newLeafNode(lv_name_6_0, grammarAccess.getPredicateFunctionAccess().getNameWhappensBeforeKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_6_0, "WhappensBefore");
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_7, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMyDsl.g:3140:4: ( (lv_event_8_0= ruleEvent ) )
                    // InternalMyDsl.g:3141:5: (lv_event_8_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3141:5: (lv_event_8_0= ruleEvent )
                    // InternalMyDsl.g:3142:6: lv_event_8_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_event_8_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_8_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,21,FOLLOW_47); 

                    				newLeafNode(otherlv_9, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalMyDsl.g:3163:4: ( (lv_point_10_0= rulePoint ) )
                    // InternalMyDsl.g:3164:5: (lv_point_10_0= rulePoint )
                    {
                    // InternalMyDsl.g:3164:5: (lv_point_10_0= rulePoint )
                    // InternalMyDsl.g:3165:6: lv_point_10_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_1_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_point_10_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_10_0,
                    							"org.xtext.example.mydsl.MyDsl.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3188:3: ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' )
                    {
                    // InternalMyDsl.g:3188:3: ( () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')' )
                    // InternalMyDsl.g:3189:4: () ( (lv_name_13_0= 'ShappensBefore' ) ) otherlv_14= '(' ( (lv_event_15_0= ruleEvent ) ) otherlv_16= ',' ( (lv_point_17_0= rulePoint ) ) otherlv_18= ')'
                    {
                    // InternalMyDsl.g:3189:4: ()
                    // InternalMyDsl.g:3190:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionSHappensBeforeAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3196:4: ( (lv_name_13_0= 'ShappensBefore' ) )
                    // InternalMyDsl.g:3197:5: (lv_name_13_0= 'ShappensBefore' )
                    {
                    // InternalMyDsl.g:3197:5: (lv_name_13_0= 'ShappensBefore' )
                    // InternalMyDsl.g:3198:6: lv_name_13_0= 'ShappensBefore'
                    {
                    lv_name_13_0=(Token)match(input,64,FOLLOW_12); 

                    						newLeafNode(lv_name_13_0, grammarAccess.getPredicateFunctionAccess().getNameShappensBeforeKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_13_0, "ShappensBefore");
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_14, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMyDsl.g:3214:4: ( (lv_event_15_0= ruleEvent ) )
                    // InternalMyDsl.g:3215:5: (lv_event_15_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3215:5: (lv_event_15_0= ruleEvent )
                    // InternalMyDsl.g:3216:6: lv_event_15_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_event_15_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_15_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_16=(Token)match(input,21,FOLLOW_47); 

                    				newLeafNode(otherlv_16, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_2_4());
                    			
                    // InternalMyDsl.g:3237:4: ( (lv_point_17_0= rulePoint ) )
                    // InternalMyDsl.g:3238:5: (lv_point_17_0= rulePoint )
                    {
                    // InternalMyDsl.g:3238:5: (lv_point_17_0= rulePoint )
                    // InternalMyDsl.g:3239:6: lv_point_17_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_2_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_point_17_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_17_0,
                    							"org.xtext.example.mydsl.MyDsl.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_18=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_18, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_2_6());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3262:3: ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' )
                    {
                    // InternalMyDsl.g:3262:3: ( () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')' )
                    // InternalMyDsl.g:3263:4: () ( (lv_name_20_0= 'HappensWithin' ) ) otherlv_21= '(' ( (lv_event_22_0= ruleEvent ) ) otherlv_23= ',' ( (lv_interval_24_0= ruleInterval ) ) otherlv_25= ')'
                    {
                    // InternalMyDsl.g:3263:4: ()
                    // InternalMyDsl.g:3264:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensWithinAction_3_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3270:4: ( (lv_name_20_0= 'HappensWithin' ) )
                    // InternalMyDsl.g:3271:5: (lv_name_20_0= 'HappensWithin' )
                    {
                    // InternalMyDsl.g:3271:5: (lv_name_20_0= 'HappensWithin' )
                    // InternalMyDsl.g:3272:6: lv_name_20_0= 'HappensWithin'
                    {
                    lv_name_20_0=(Token)match(input,65,FOLLOW_12); 

                    						newLeafNode(lv_name_20_0, grammarAccess.getPredicateFunctionAccess().getNameHappensWithinKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_20_0, "HappensWithin");
                    					

                    }


                    }

                    otherlv_21=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_21, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_3_2());
                    			
                    // InternalMyDsl.g:3288:4: ( (lv_event_22_0= ruleEvent ) )
                    // InternalMyDsl.g:3289:5: (lv_event_22_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3289:5: (lv_event_22_0= ruleEvent )
                    // InternalMyDsl.g:3290:6: lv_event_22_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_3_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_event_22_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_22_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,21,FOLLOW_48); 

                    				newLeafNode(otherlv_23, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_3_4());
                    			
                    // InternalMyDsl.g:3311:4: ( (lv_interval_24_0= ruleInterval ) )
                    // InternalMyDsl.g:3312:5: (lv_interval_24_0= ruleInterval )
                    {
                    // InternalMyDsl.g:3312:5: (lv_interval_24_0= ruleInterval )
                    // InternalMyDsl.g:3313:6: lv_interval_24_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getIntervalIntervalParserRuleCall_3_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_interval_24_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_24_0,
                    							"org.xtext.example.mydsl.MyDsl.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_25=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_25, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_3_6());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3336:3: ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' )
                    {
                    // InternalMyDsl.g:3336:3: ( () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')' )
                    // InternalMyDsl.g:3337:4: () ( (lv_name_27_0= 'WhappensBeforeE' ) ) otherlv_28= '(' ( (lv_event1_29_0= ruleEvent ) ) otherlv_30= ',' ( (lv_event2_31_0= ruleEvent ) ) otherlv_32= ')'
                    {
                    // InternalMyDsl.g:3337:4: ()
                    // InternalMyDsl.g:3338:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionWHappensBeforeEventAction_4_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3344:4: ( (lv_name_27_0= 'WhappensBeforeE' ) )
                    // InternalMyDsl.g:3345:5: (lv_name_27_0= 'WhappensBeforeE' )
                    {
                    // InternalMyDsl.g:3345:5: (lv_name_27_0= 'WhappensBeforeE' )
                    // InternalMyDsl.g:3346:6: lv_name_27_0= 'WhappensBeforeE'
                    {
                    lv_name_27_0=(Token)match(input,66,FOLLOW_12); 

                    						newLeafNode(lv_name_27_0, grammarAccess.getPredicateFunctionAccess().getNameWhappensBeforeEKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_27_0, "WhappensBeforeE");
                    					

                    }


                    }

                    otherlv_28=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_28, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    // InternalMyDsl.g:3362:4: ( (lv_event1_29_0= ruleEvent ) )
                    // InternalMyDsl.g:3363:5: (lv_event1_29_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3363:5: (lv_event1_29_0= ruleEvent )
                    // InternalMyDsl.g:3364:6: lv_event1_29_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent1EventParserRuleCall_4_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_event1_29_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event1",
                    							lv_event1_29_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_30=(Token)match(input,21,FOLLOW_47); 

                    				newLeafNode(otherlv_30, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_4_4());
                    			
                    // InternalMyDsl.g:3385:4: ( (lv_event2_31_0= ruleEvent ) )
                    // InternalMyDsl.g:3386:5: (lv_event2_31_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3386:5: (lv_event2_31_0= ruleEvent )
                    // InternalMyDsl.g:3387:6: lv_event2_31_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent2EventParserRuleCall_4_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_event2_31_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event2",
                    							lv_event2_31_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_32=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_32, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_4_6());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:3410:3: ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' )
                    {
                    // InternalMyDsl.g:3410:3: ( () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')' )
                    // InternalMyDsl.g:3411:4: () ( (lv_name_34_0= 'ShappensBeforeE' ) ) otherlv_35= '(' ( (lv_event1_36_0= ruleEvent ) ) otherlv_37= ',' ( (lv_event2_38_0= ruleEvent ) ) otherlv_39= ')'
                    {
                    // InternalMyDsl.g:3411:4: ()
                    // InternalMyDsl.g:3412:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionSHappensBeforeEventAction_5_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3418:4: ( (lv_name_34_0= 'ShappensBeforeE' ) )
                    // InternalMyDsl.g:3419:5: (lv_name_34_0= 'ShappensBeforeE' )
                    {
                    // InternalMyDsl.g:3419:5: (lv_name_34_0= 'ShappensBeforeE' )
                    // InternalMyDsl.g:3420:6: lv_name_34_0= 'ShappensBeforeE'
                    {
                    lv_name_34_0=(Token)match(input,67,FOLLOW_12); 

                    						newLeafNode(lv_name_34_0, grammarAccess.getPredicateFunctionAccess().getNameShappensBeforeEKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_34_0, "ShappensBeforeE");
                    					

                    }


                    }

                    otherlv_35=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_35, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalMyDsl.g:3436:4: ( (lv_event1_36_0= ruleEvent ) )
                    // InternalMyDsl.g:3437:5: (lv_event1_36_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3437:5: (lv_event1_36_0= ruleEvent )
                    // InternalMyDsl.g:3438:6: lv_event1_36_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent1EventParserRuleCall_5_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_event1_36_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event1",
                    							lv_event1_36_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_37=(Token)match(input,21,FOLLOW_47); 

                    				newLeafNode(otherlv_37, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_5_4());
                    			
                    // InternalMyDsl.g:3459:4: ( (lv_event2_38_0= ruleEvent ) )
                    // InternalMyDsl.g:3460:5: (lv_event2_38_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3460:5: (lv_event2_38_0= ruleEvent )
                    // InternalMyDsl.g:3461:6: lv_event2_38_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEvent2EventParserRuleCall_5_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_event2_38_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event2",
                    							lv_event2_38_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_39=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_39, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_5_6());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:3484:3: ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' )
                    {
                    // InternalMyDsl.g:3484:3: ( () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')' )
                    // InternalMyDsl.g:3485:4: () ( (lv_name_41_0= 'HappensAfter' ) ) otherlv_42= '(' ( (lv_event_43_0= ruleEvent ) ) otherlv_44= ',' ( (lv_point_45_0= rulePoint ) ) otherlv_46= ')'
                    {
                    // InternalMyDsl.g:3485:4: ()
                    // InternalMyDsl.g:3486:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionHappensAfterAction_6_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3492:4: ( (lv_name_41_0= 'HappensAfter' ) )
                    // InternalMyDsl.g:3493:5: (lv_name_41_0= 'HappensAfter' )
                    {
                    // InternalMyDsl.g:3493:5: (lv_name_41_0= 'HappensAfter' )
                    // InternalMyDsl.g:3494:6: lv_name_41_0= 'HappensAfter'
                    {
                    lv_name_41_0=(Token)match(input,68,FOLLOW_12); 

                    						newLeafNode(lv_name_41_0, grammarAccess.getPredicateFunctionAccess().getNameHappensAfterKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_41_0, "HappensAfter");
                    					

                    }


                    }

                    otherlv_42=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_42, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_6_2());
                    			
                    // InternalMyDsl.g:3510:4: ( (lv_event_43_0= ruleEvent ) )
                    // InternalMyDsl.g:3511:5: (lv_event_43_0= ruleEvent )
                    {
                    // InternalMyDsl.g:3511:5: (lv_event_43_0= ruleEvent )
                    // InternalMyDsl.g:3512:6: lv_event_43_0= ruleEvent
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getEventEventParserRuleCall_6_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_event_43_0=ruleEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"event",
                    							lv_event_43_0,
                    							"org.xtext.example.mydsl.MyDsl.Event");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_44=(Token)match(input,21,FOLLOW_47); 

                    				newLeafNode(otherlv_44, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_6_4());
                    			
                    // InternalMyDsl.g:3533:4: ( (lv_point_45_0= rulePoint ) )
                    // InternalMyDsl.g:3534:5: (lv_point_45_0= rulePoint )
                    {
                    // InternalMyDsl.g:3534:5: (lv_point_45_0= rulePoint )
                    // InternalMyDsl.g:3535:6: lv_point_45_0= rulePoint
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getPointPointParserRuleCall_6_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_point_45_0=rulePoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"point",
                    							lv_point_45_0,
                    							"org.xtext.example.mydsl.MyDsl.Point");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_46=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_46, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_6_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:3558:3: ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' )
                    {
                    // InternalMyDsl.g:3558:3: ( () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')' )
                    // InternalMyDsl.g:3559:4: () ( (lv_name_48_0= 'Occurs' ) ) otherlv_49= '(' ( (lv_situation_50_0= ruleSituation ) ) otherlv_51= ',' ( (lv_interval_52_0= ruleInterval ) ) otherlv_53= ')'
                    {
                    // InternalMyDsl.g:3559:4: ()
                    // InternalMyDsl.g:3560:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPredicateFunctionAccess().getPredicateFunctionOccursAction_7_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:3566:4: ( (lv_name_48_0= 'Occurs' ) )
                    // InternalMyDsl.g:3567:5: (lv_name_48_0= 'Occurs' )
                    {
                    // InternalMyDsl.g:3567:5: (lv_name_48_0= 'Occurs' )
                    // InternalMyDsl.g:3568:6: lv_name_48_0= 'Occurs'
                    {
                    lv_name_48_0=(Token)match(input,69,FOLLOW_12); 

                    						newLeafNode(lv_name_48_0, grammarAccess.getPredicateFunctionAccess().getNameOccursKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPredicateFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_48_0, "Occurs");
                    					

                    }


                    }

                    otherlv_49=(Token)match(input,20,FOLLOW_48); 

                    				newLeafNode(otherlv_49, grammarAccess.getPredicateFunctionAccess().getLeftParenthesisKeyword_7_2());
                    			
                    // InternalMyDsl.g:3584:4: ( (lv_situation_50_0= ruleSituation ) )
                    // InternalMyDsl.g:3585:5: (lv_situation_50_0= ruleSituation )
                    {
                    // InternalMyDsl.g:3585:5: (lv_situation_50_0= ruleSituation )
                    // InternalMyDsl.g:3586:6: lv_situation_50_0= ruleSituation
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getSituationSituationParserRuleCall_7_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_situation_50_0=ruleSituation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"situation",
                    							lv_situation_50_0,
                    							"org.xtext.example.mydsl.MyDsl.Situation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_51=(Token)match(input,21,FOLLOW_48); 

                    				newLeafNode(otherlv_51, grammarAccess.getPredicateFunctionAccess().getCommaKeyword_7_4());
                    			
                    // InternalMyDsl.g:3607:4: ( (lv_interval_52_0= ruleInterval ) )
                    // InternalMyDsl.g:3608:5: (lv_interval_52_0= ruleInterval )
                    {
                    // InternalMyDsl.g:3608:5: (lv_interval_52_0= ruleInterval )
                    // InternalMyDsl.g:3609:6: lv_interval_52_0= ruleInterval
                    {

                    						newCompositeNode(grammarAccess.getPredicateFunctionAccess().getIntervalIntervalParserRuleCall_7_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_interval_52_0=ruleInterval();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPredicateFunctionRule());
                    						}
                    						set(
                    							current,
                    							"interval",
                    							lv_interval_52_0,
                    							"org.xtext.example.mydsl.MyDsl.Interval");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_53=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_53, grammarAccess.getPredicateFunctionAccess().getRightParenthesisKeyword_7_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicateFunction"


    // $ANTLR start "entryRuleEvent"
    // InternalMyDsl.g:3635:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalMyDsl.g:3635:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalMyDsl.g:3636:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalMyDsl.g:3642:1: ruleEvent returns [EObject current=null] : (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        EObject this_VariableEvent_0 = null;

        EObject this_ObligationEvent_1 = null;

        EObject this_ContractEvent_2 = null;

        EObject this_PowerEvent_3 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3648:2: ( (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent ) )
            // InternalMyDsl.g:3649:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent )
            {
            // InternalMyDsl.g:3649:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent )
            int alt35=4;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalMyDsl.g:3650:3: this_VariableEvent_0= ruleVariableEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getVariableEventParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableEvent_0=ruleVariableEvent();

                    state._fsp--;


                    			current = this_VariableEvent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3659:3: this_ObligationEvent_1= ruleObligationEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getObligationEventParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObligationEvent_1=ruleObligationEvent();

                    state._fsp--;


                    			current = this_ObligationEvent_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3668:3: this_ContractEvent_2= ruleContractEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getContractEventParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContractEvent_2=ruleContractEvent();

                    state._fsp--;


                    			current = this_ContractEvent_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3677:3: this_PowerEvent_3= rulePowerEvent
                    {

                    			newCompositeNode(grammarAccess.getEventAccess().getPowerEventParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerEvent_3=rulePowerEvent();

                    state._fsp--;


                    			current = this_PowerEvent_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleVariableEvent"
    // InternalMyDsl.g:3689:1: entryRuleVariableEvent returns [EObject current=null] : iv_ruleVariableEvent= ruleVariableEvent EOF ;
    public final EObject entryRuleVariableEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEvent = null;


        try {
            // InternalMyDsl.g:3689:54: (iv_ruleVariableEvent= ruleVariableEvent EOF )
            // InternalMyDsl.g:3690:2: iv_ruleVariableEvent= ruleVariableEvent EOF
            {
             newCompositeNode(grammarAccess.getVariableEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableEvent=ruleVariableEvent();

            state._fsp--;

             current =iv_ruleVariableEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableEvent"


    // $ANTLR start "ruleVariableEvent"
    // InternalMyDsl.g:3696:1: ruleVariableEvent returns [EObject current=null] : ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) ;
    public final EObject ruleVariableEvent() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3702:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) )
            // InternalMyDsl.g:3703:2: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
            {
            // InternalMyDsl.g:3703:2: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
            // InternalMyDsl.g:3704:3: () ( (lv_variable_1_0= ruleVariableDotExpression ) )
            {
            // InternalMyDsl.g:3704:3: ()
            // InternalMyDsl.g:3705:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableEventAccess().getVariableEventAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:3711:3: ( (lv_variable_1_0= ruleVariableDotExpression ) )
            // InternalMyDsl.g:3712:4: (lv_variable_1_0= ruleVariableDotExpression )
            {
            // InternalMyDsl.g:3712:4: (lv_variable_1_0= ruleVariableDotExpression )
            // InternalMyDsl.g:3713:5: lv_variable_1_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getVariableEventAccess().getVariableVariableDotExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_variable_1_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableEventRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableEvent"


    // $ANTLR start "entryRulePowerEvent"
    // InternalMyDsl.g:3734:1: entryRulePowerEvent returns [EObject current=null] : iv_rulePowerEvent= rulePowerEvent EOF ;
    public final EObject entryRulePowerEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerEvent = null;


        try {
            // InternalMyDsl.g:3734:51: (iv_rulePowerEvent= rulePowerEvent EOF )
            // InternalMyDsl.g:3735:2: iv_rulePowerEvent= rulePowerEvent EOF
            {
             newCompositeNode(grammarAccess.getPowerEventRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerEvent=rulePowerEvent();

            state._fsp--;

             current =iv_rulePowerEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerEvent"


    // $ANTLR start "rulePowerEvent"
    // InternalMyDsl.g:3741:1: rulePowerEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) ;
    public final EObject rulePowerEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3747:2: ( ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) )
            // InternalMyDsl.g:3748:2: ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            {
            // InternalMyDsl.g:3748:2: ( () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            // InternalMyDsl.g:3749:3: () ( (lv_eventName_1_0= rulePowerEventName ) ) otherlv_2= '(' otherlv_3= 'powers.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
            {
            // InternalMyDsl.g:3749:3: ()
            // InternalMyDsl.g:3750:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPowerEventAccess().getPowerEventAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:3756:3: ( (lv_eventName_1_0= rulePowerEventName ) )
            // InternalMyDsl.g:3757:4: (lv_eventName_1_0= rulePowerEventName )
            {
            // InternalMyDsl.g:3757:4: (lv_eventName_1_0= rulePowerEventName )
            // InternalMyDsl.g:3758:5: lv_eventName_1_0= rulePowerEventName
            {

            					newCompositeNode(grammarAccess.getPowerEventAccess().getEventNamePowerEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
            lv_eventName_1_0=rulePowerEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"org.xtext.example.mydsl.MyDsl.PowerEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_49); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,70,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getPowerEventAccess().getPowersKeyword_3());
            		
            // InternalMyDsl.g:3783:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDsl.g:3784:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDsl.g:3784:4: (otherlv_4= RULE_ID )
            // InternalMyDsl.g:3785:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerEventRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_4, grammarAccess.getPowerEventAccess().getPowerVariablePowerWrapperCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getPowerEventAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerEvent"


    // $ANTLR start "entryRulePowerEventName"
    // InternalMyDsl.g:3804:1: entryRulePowerEventName returns [String current=null] : iv_rulePowerEventName= rulePowerEventName EOF ;
    public final String entryRulePowerEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowerEventName = null;


        try {
            // InternalMyDsl.g:3804:54: (iv_rulePowerEventName= rulePowerEventName EOF )
            // InternalMyDsl.g:3805:2: iv_rulePowerEventName= rulePowerEventName EOF
            {
             newCompositeNode(grammarAccess.getPowerEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerEventName=rulePowerEventName();

            state._fsp--;

             current =iv_rulePowerEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerEventName"


    // $ANTLR start "rulePowerEventName"
    // InternalMyDsl.g:3811:1: rulePowerEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' ) ;
    public final AntlrDatatypeRuleToken rulePowerEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3817:2: ( (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' ) )
            // InternalMyDsl.g:3818:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' )
            {
            // InternalMyDsl.g:3818:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Exerted' | kw= 'Expired' | kw= 'Terminated' )
            int alt36=7;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt36=1;
                }
                break;
            case 72:
                {
                alt36=2;
                }
                break;
            case 73:
                {
                alt36=3;
                }
                break;
            case 74:
                {
                alt36=4;
                }
                break;
            case 75:
                {
                alt36=5;
                }
                break;
            case 76:
                {
                alt36=6;
                }
                break;
            case 77:
                {
                alt36=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalMyDsl.g:3819:3: kw= 'Triggered'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getTriggeredKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3825:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getActivatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3831:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getSuspendedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3837:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getResumedKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3843:3: kw= 'Exerted'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getExertedKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:3849:3: kw= 'Expired'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getExpiredKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:3855:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerEventNameAccess().getTerminatedKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerEventName"


    // $ANTLR start "entryRuleObligationEvent"
    // InternalMyDsl.g:3864:1: entryRuleObligationEvent returns [EObject current=null] : iv_ruleObligationEvent= ruleObligationEvent EOF ;
    public final EObject entryRuleObligationEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligationEvent = null;


        try {
            // InternalMyDsl.g:3864:56: (iv_ruleObligationEvent= ruleObligationEvent EOF )
            // InternalMyDsl.g:3865:2: iv_ruleObligationEvent= ruleObligationEvent EOF
            {
             newCompositeNode(grammarAccess.getObligationEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationEvent=ruleObligationEvent();

            state._fsp--;

             current =iv_ruleObligationEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationEvent"


    // $ANTLR start "ruleObligationEvent"
    // InternalMyDsl.g:3871:1: ruleObligationEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) ;
    public final EObject ruleObligationEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3877:2: ( ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) )
            // InternalMyDsl.g:3878:2: ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            {
            // InternalMyDsl.g:3878:2: ( () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
            // InternalMyDsl.g:3879:3: () ( (lv_eventName_1_0= ruleObligationEventName ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
            {
            // InternalMyDsl.g:3879:3: ()
            // InternalMyDsl.g:3880:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getObligationEventAccess().getObligationEventAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:3886:3: ( (lv_eventName_1_0= ruleObligationEventName ) )
            // InternalMyDsl.g:3887:4: (lv_eventName_1_0= ruleObligationEventName )
            {
            // InternalMyDsl.g:3887:4: (lv_eventName_1_0= ruleObligationEventName )
            // InternalMyDsl.g:3888:5: lv_eventName_1_0= ruleObligationEventName
            {

            					newCompositeNode(grammarAccess.getObligationEventAccess().getEventNameObligationEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
            lv_eventName_1_0=ruleObligationEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"org.xtext.example.mydsl.MyDsl.ObligationEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getObligationEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,78,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getObligationEventAccess().getObligationsKeyword_3());
            		
            // InternalMyDsl.g:3913:3: ( (otherlv_4= RULE_ID ) )
            // InternalMyDsl.g:3914:4: (otherlv_4= RULE_ID )
            {
            // InternalMyDsl.g:3914:4: (otherlv_4= RULE_ID )
            // InternalMyDsl.g:3915:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationEventRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_4, grammarAccess.getObligationEventAccess().getObligationVariableObligationWrapperCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getObligationEventAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationEvent"


    // $ANTLR start "entryRuleObligationEventName"
    // InternalMyDsl.g:3934:1: entryRuleObligationEventName returns [String current=null] : iv_ruleObligationEventName= ruleObligationEventName EOF ;
    public final String entryRuleObligationEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleObligationEventName = null;


        try {
            // InternalMyDsl.g:3934:59: (iv_ruleObligationEventName= ruleObligationEventName EOF )
            // InternalMyDsl.g:3935:2: iv_ruleObligationEventName= ruleObligationEventName EOF
            {
             newCompositeNode(grammarAccess.getObligationEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationEventName=ruleObligationEventName();

            state._fsp--;

             current =iv_ruleObligationEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationEventName"


    // $ANTLR start "ruleObligationEventName"
    // InternalMyDsl.g:3941:1: ruleObligationEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' ) ;
    public final AntlrDatatypeRuleToken ruleObligationEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3947:2: ( (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' ) )
            // InternalMyDsl.g:3948:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' )
            {
            // InternalMyDsl.g:3948:2: (kw= 'Triggered' | kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'Discharged' | kw= 'Expired' | kw= 'Fulfilled' | kw= 'Violated' | kw= 'Terminated' )
            int alt37=9;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt37=1;
                }
                break;
            case 72:
                {
                alt37=2;
                }
                break;
            case 73:
                {
                alt37=3;
                }
                break;
            case 74:
                {
                alt37=4;
                }
                break;
            case 79:
                {
                alt37=5;
                }
                break;
            case 76:
                {
                alt37=6;
                }
                break;
            case 80:
                {
                alt37=7;
                }
                break;
            case 81:
                {
                alt37=8;
                }
                break;
            case 77:
                {
                alt37=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalMyDsl.g:3949:3: kw= 'Triggered'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getTriggeredKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3955:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getActivatedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3961:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getSuspendedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3967:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getResumedKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3973:3: kw= 'Discharged'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getDischargedKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:3979:3: kw= 'Expired'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getExpiredKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:3985:3: kw= 'Fulfilled'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getFulfilledKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:3991:3: kw= 'Violated'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getViolatedKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:3997:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationEventNameAccess().getTerminatedKeyword_8());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationEventName"


    // $ANTLR start "entryRuleContractEvent"
    // InternalMyDsl.g:4006:1: entryRuleContractEvent returns [EObject current=null] : iv_ruleContractEvent= ruleContractEvent EOF ;
    public final EObject entryRuleContractEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractEvent = null;


        try {
            // InternalMyDsl.g:4006:54: (iv_ruleContractEvent= ruleContractEvent EOF )
            // InternalMyDsl.g:4007:2: iv_ruleContractEvent= ruleContractEvent EOF
            {
             newCompositeNode(grammarAccess.getContractEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractEvent=ruleContractEvent();

            state._fsp--;

             current =iv_ruleContractEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractEvent"


    // $ANTLR start "ruleContractEvent"
    // InternalMyDsl.g:4013:1: ruleContractEvent returns [EObject current=null] : ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' ) ;
    public final EObject ruleContractEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_eventName_1_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4019:2: ( ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' ) )
            // InternalMyDsl.g:4020:2: ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' )
            {
            // InternalMyDsl.g:4020:2: ( () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')' )
            // InternalMyDsl.g:4021:3: () ( (lv_eventName_1_0= ruleContractEventName ) ) otherlv_2= '(' otherlv_3= 'self' otherlv_4= ')'
            {
            // InternalMyDsl.g:4021:3: ()
            // InternalMyDsl.g:4022:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getContractEventAccess().getContractEventAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:4028:3: ( (lv_eventName_1_0= ruleContractEventName ) )
            // InternalMyDsl.g:4029:4: (lv_eventName_1_0= ruleContractEventName )
            {
            // InternalMyDsl.g:4029:4: (lv_eventName_1_0= ruleContractEventName )
            // InternalMyDsl.g:4030:5: lv_eventName_1_0= ruleContractEventName
            {

            					newCompositeNode(grammarAccess.getContractEventAccess().getEventNameContractEventNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
            lv_eventName_1_0=ruleContractEventName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractEventRule());
            					}
            					set(
            						current,
            						"eventName",
            						lv_eventName_1_0,
            						"org.xtext.example.mydsl.MyDsl.ContractEventName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_51); 

            			newLeafNode(otherlv_2, grammarAccess.getContractEventAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,82,FOLLOW_42); 

            			newLeafNode(otherlv_3, grammarAccess.getContractEventAccess().getSelfKeyword_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getContractEventAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractEvent"


    // $ANTLR start "entryRuleContractEventName"
    // InternalMyDsl.g:4063:1: entryRuleContractEventName returns [String current=null] : iv_ruleContractEventName= ruleContractEventName EOF ;
    public final String entryRuleContractEventName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractEventName = null;


        try {
            // InternalMyDsl.g:4063:57: (iv_ruleContractEventName= ruleContractEventName EOF )
            // InternalMyDsl.g:4064:2: iv_ruleContractEventName= ruleContractEventName EOF
            {
             newCompositeNode(grammarAccess.getContractEventNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractEventName=ruleContractEventName();

            state._fsp--;

             current =iv_ruleContractEventName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractEventName"


    // $ANTLR start "ruleContractEventName"
    // InternalMyDsl.g:4070:1: ruleContractEventName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' ) ;
    public final AntlrDatatypeRuleToken ruleContractEventName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4076:2: ( (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' ) )
            // InternalMyDsl.g:4077:2: (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' )
            {
            // InternalMyDsl.g:4077:2: (kw= 'Activated' | kw= 'Suspended' | kw= 'Resumed' | kw= 'FulfilledObligations' | kw= 'RevokedParty' | kw= 'AssignedParty' | kw= 'Terminated' | kw= 'Rescinded' )
            int alt38=8;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt38=1;
                }
                break;
            case 73:
                {
                alt38=2;
                }
                break;
            case 74:
                {
                alt38=3;
                }
                break;
            case 83:
                {
                alt38=4;
                }
                break;
            case 84:
                {
                alt38=5;
                }
                break;
            case 85:
                {
                alt38=6;
                }
                break;
            case 77:
                {
                alt38=7;
                }
                break;
            case 86:
                {
                alt38=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalMyDsl.g:4078:3: kw= 'Activated'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getActivatedKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4084:3: kw= 'Suspended'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getSuspendedKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:4090:3: kw= 'Resumed'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getResumedKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:4096:3: kw= 'FulfilledObligations'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getFulfilledObligationsKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:4102:3: kw= 'RevokedParty'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getRevokedPartyKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:4108:3: kw= 'AssignedParty'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getAssignedPartyKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:4114:3: kw= 'Terminated'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getTerminatedKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:4120:3: kw= 'Rescinded'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractEventNameAccess().getRescindedKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractEventName"


    // $ANTLR start "entryRulePoint"
    // InternalMyDsl.g:4129:1: entryRulePoint returns [EObject current=null] : iv_rulePoint= rulePoint EOF ;
    public final EObject entryRulePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePoint = null;


        try {
            // InternalMyDsl.g:4129:46: (iv_rulePoint= rulePoint EOF )
            // InternalMyDsl.g:4130:2: iv_rulePoint= rulePoint EOF
            {
             newCompositeNode(grammarAccess.getPointRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePoint=rulePoint();

            state._fsp--;

             current =iv_rulePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePoint"


    // $ANTLR start "rulePoint"
    // InternalMyDsl.g:4136:1: rulePoint returns [EObject current=null] : ( (lv_pointExpression_0_0= rulePointExpression ) ) ;
    public final EObject rulePoint() throws RecognitionException {
        EObject current = null;

        EObject lv_pointExpression_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4142:2: ( ( (lv_pointExpression_0_0= rulePointExpression ) ) )
            // InternalMyDsl.g:4143:2: ( (lv_pointExpression_0_0= rulePointExpression ) )
            {
            // InternalMyDsl.g:4143:2: ( (lv_pointExpression_0_0= rulePointExpression ) )
            // InternalMyDsl.g:4144:3: (lv_pointExpression_0_0= rulePointExpression )
            {
            // InternalMyDsl.g:4144:3: (lv_pointExpression_0_0= rulePointExpression )
            // InternalMyDsl.g:4145:4: lv_pointExpression_0_0= rulePointExpression
            {

            				newCompositeNode(grammarAccess.getPointAccess().getPointExpressionPointExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_pointExpression_0_0=rulePointExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPointRule());
            				}
            				set(
            					current,
            					"pointExpression",
            					lv_pointExpression_0_0,
            					"org.xtext.example.mydsl.MyDsl.PointExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePoint"


    // $ANTLR start "entryRulePointExpression"
    // InternalMyDsl.g:4165:1: entryRulePointExpression returns [EObject current=null] : iv_rulePointExpression= rulePointExpression EOF ;
    public final EObject entryRulePointExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointExpression = null;


        try {
            // InternalMyDsl.g:4165:56: (iv_rulePointExpression= rulePointExpression EOF )
            // InternalMyDsl.g:4166:2: iv_rulePointExpression= rulePointExpression EOF
            {
             newCompositeNode(grammarAccess.getPointExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointExpression=rulePointExpression();

            state._fsp--;

             current =iv_rulePointExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointExpression"


    // $ANTLR start "rulePointExpression"
    // InternalMyDsl.g:4172:1: rulePointExpression returns [EObject current=null] : (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom ) ;
    public final EObject rulePointExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PointFunction_0 = null;

        EObject this_PointAtom_1 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4178:2: ( (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom ) )
            // InternalMyDsl.g:4179:2: (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom )
            {
            // InternalMyDsl.g:4179:2: (this_PointFunction_0= rulePointFunction | this_PointAtom_1= rulePointAtom )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==87) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_ID||(LA39_0>=71 && LA39_0<=77)||(LA39_0>=79 && LA39_0<=81)||(LA39_0>=83 && LA39_0<=86)) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalMyDsl.g:4180:3: this_PointFunction_0= rulePointFunction
                    {

                    			newCompositeNode(grammarAccess.getPointExpressionAccess().getPointFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PointFunction_0=rulePointFunction();

                    state._fsp--;


                    			current = this_PointFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4189:3: this_PointAtom_1= rulePointAtom
                    {

                    			newCompositeNode(grammarAccess.getPointExpressionAccess().getPointAtomParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PointAtom_1=rulePointAtom();

                    state._fsp--;


                    			current = this_PointAtom_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointExpression"


    // $ANTLR start "entryRulePointFunction"
    // InternalMyDsl.g:4201:1: entryRulePointFunction returns [EObject current=null] : iv_rulePointFunction= rulePointFunction EOF ;
    public final EObject entryRulePointFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointFunction = null;


        try {
            // InternalMyDsl.g:4201:54: (iv_rulePointFunction= rulePointFunction EOF )
            // InternalMyDsl.g:4202:2: iv_rulePointFunction= rulePointFunction EOF
            {
             newCompositeNode(grammarAccess.getPointFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointFunction=rulePointFunction();

            state._fsp--;

             current =iv_rulePointFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointFunction"


    // $ANTLR start "rulePointFunction"
    // InternalMyDsl.g:4208:1: rulePointFunction returns [EObject current=null] : ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) ;
    public final EObject rulePointFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_arg_3_0 = null;

        EObject lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_timeUnit_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4214:2: ( ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) )
            // InternalMyDsl.g:4215:2: ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            {
            // InternalMyDsl.g:4215:2: ( () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            // InternalMyDsl.g:4216:3: () ( (lv_name_1_0= rulePointFunctionName ) ) otherlv_2= '(' ( (lv_arg_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTimevalue ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')'
            {
            // InternalMyDsl.g:4216:3: ()
            // InternalMyDsl.g:4217:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPointFunctionAccess().getPointFunctionAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:4223:3: ( (lv_name_1_0= rulePointFunctionName ) )
            // InternalMyDsl.g:4224:4: (lv_name_1_0= rulePointFunctionName )
            {
            // InternalMyDsl.g:4224:4: (lv_name_1_0= rulePointFunctionName )
            // InternalMyDsl.g:4225:5: lv_name_1_0= rulePointFunctionName
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getNamePointFunctionNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_12);
            lv_name_1_0=rulePointFunctionName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.PointFunctionName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getPointFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMyDsl.g:4246:3: ( (lv_arg_3_0= rulePointExpression ) )
            // InternalMyDsl.g:4247:4: (lv_arg_3_0= rulePointExpression )
            {
            // InternalMyDsl.g:4247:4: (lv_arg_3_0= rulePointExpression )
            // InternalMyDsl.g:4248:5: lv_arg_3_0= rulePointExpression
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getArgPointExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_43);
            lv_arg_3_0=rulePointExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"arg",
            						lv_arg_3_0,
            						"org.xtext.example.mydsl.MyDsl.PointExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_24); 

            			newLeafNode(otherlv_4, grammarAccess.getPointFunctionAccess().getCommaKeyword_4());
            		
            // InternalMyDsl.g:4269:3: ( (lv_value_5_0= ruleTimevalue ) )
            // InternalMyDsl.g:4270:4: (lv_value_5_0= ruleTimevalue )
            {
            // InternalMyDsl.g:4270:4: (lv_value_5_0= ruleTimevalue )
            // InternalMyDsl.g:4271:5: lv_value_5_0= ruleTimevalue
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getValueTimevalueParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_43);
            lv_value_5_0=ruleTimevalue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"org.xtext.example.mydsl.MyDsl.Timevalue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_52); 

            			newLeafNode(otherlv_6, grammarAccess.getPointFunctionAccess().getCommaKeyword_6());
            		
            // InternalMyDsl.g:4292:3: ( (lv_timeUnit_7_0= ruleTimeUnit ) )
            // InternalMyDsl.g:4293:4: (lv_timeUnit_7_0= ruleTimeUnit )
            {
            // InternalMyDsl.g:4293:4: (lv_timeUnit_7_0= ruleTimeUnit )
            // InternalMyDsl.g:4294:5: lv_timeUnit_7_0= ruleTimeUnit
            {

            					newCompositeNode(grammarAccess.getPointFunctionAccess().getTimeUnitTimeUnitParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_42);
            lv_timeUnit_7_0=ruleTimeUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointFunctionRule());
            					}
            					set(
            						current,
            						"timeUnit",
            						lv_timeUnit_7_0,
            						"org.xtext.example.mydsl.MyDsl.TimeUnit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getPointFunctionAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointFunction"


    // $ANTLR start "entryRulePointFunctionName"
    // InternalMyDsl.g:4319:1: entryRulePointFunctionName returns [String current=null] : iv_rulePointFunctionName= rulePointFunctionName EOF ;
    public final String entryRulePointFunctionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePointFunctionName = null;


        try {
            // InternalMyDsl.g:4319:57: (iv_rulePointFunctionName= rulePointFunctionName EOF )
            // InternalMyDsl.g:4320:2: iv_rulePointFunctionName= rulePointFunctionName EOF
            {
             newCompositeNode(grammarAccess.getPointFunctionNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointFunctionName=rulePointFunctionName();

            state._fsp--;

             current =iv_rulePointFunctionName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointFunctionName"


    // $ANTLR start "rulePointFunctionName"
    // InternalMyDsl.g:4326:1: rulePointFunctionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'Date.add' ;
    public final AntlrDatatypeRuleToken rulePointFunctionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4332:2: (kw= 'Date.add' )
            // InternalMyDsl.g:4333:2: kw= 'Date.add'
            {
            kw=(Token)match(input,87,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPointFunctionNameAccess().getDateAddKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointFunctionName"


    // $ANTLR start "entryRulePointAtom"
    // InternalMyDsl.g:4341:1: entryRulePointAtom returns [EObject current=null] : iv_rulePointAtom= rulePointAtom EOF ;
    public final EObject entryRulePointAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointAtom = null;


        try {
            // InternalMyDsl.g:4341:50: (iv_rulePointAtom= rulePointAtom EOF )
            // InternalMyDsl.g:4342:2: iv_rulePointAtom= rulePointAtom EOF
            {
             newCompositeNode(grammarAccess.getPointAtomRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointAtom=rulePointAtom();

            state._fsp--;

             current =iv_rulePointAtom; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointAtom"


    // $ANTLR start "rulePointAtom"
    // InternalMyDsl.g:4348:1: rulePointAtom returns [EObject current=null] : ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) ) ;
    public final EObject rulePointAtom() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;

        EObject lv_obligationEvent_3_0 = null;

        EObject lv_contractEvent_5_0 = null;

        EObject lv_powerEvent_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4354:2: ( ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) ) )
            // InternalMyDsl.g:4355:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )
            {
            // InternalMyDsl.g:4355:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )
            int alt40=4;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalMyDsl.g:4356:3: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalMyDsl.g:4356:3: ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) )
                    // InternalMyDsl.g:4357:4: () ( (lv_variable_1_0= ruleVariableDotExpression ) )
                    {
                    // InternalMyDsl.g:4357:4: ()
                    // InternalMyDsl.g:4358:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomParameterDotExpressionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:4364:4: ( (lv_variable_1_0= ruleVariableDotExpression ) )
                    // InternalMyDsl.g:4365:5: (lv_variable_1_0= ruleVariableDotExpression )
                    {
                    // InternalMyDsl.g:4365:5: (lv_variable_1_0= ruleVariableDotExpression )
                    // InternalMyDsl.g:4366:6: lv_variable_1_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getVariableVariableDotExpressionParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_1_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_1_0,
                    							"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4385:3: ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) )
                    {
                    // InternalMyDsl.g:4385:3: ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) )
                    // InternalMyDsl.g:4386:4: () ( (lv_obligationEvent_3_0= ruleObligationEvent ) )
                    {
                    // InternalMyDsl.g:4386:4: ()
                    // InternalMyDsl.g:4387:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomObligationEventAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:4393:4: ( (lv_obligationEvent_3_0= ruleObligationEvent ) )
                    // InternalMyDsl.g:4394:5: (lv_obligationEvent_3_0= ruleObligationEvent )
                    {
                    // InternalMyDsl.g:4394:5: (lv_obligationEvent_3_0= ruleObligationEvent )
                    // InternalMyDsl.g:4395:6: lv_obligationEvent_3_0= ruleObligationEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getObligationEventObligationEventParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_obligationEvent_3_0=ruleObligationEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"obligationEvent",
                    							lv_obligationEvent_3_0,
                    							"org.xtext.example.mydsl.MyDsl.ObligationEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:4414:3: ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) )
                    {
                    // InternalMyDsl.g:4414:3: ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) )
                    // InternalMyDsl.g:4415:4: () ( (lv_contractEvent_5_0= ruleContractEvent ) )
                    {
                    // InternalMyDsl.g:4415:4: ()
                    // InternalMyDsl.g:4416:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomContractEventAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:4422:4: ( (lv_contractEvent_5_0= ruleContractEvent ) )
                    // InternalMyDsl.g:4423:5: (lv_contractEvent_5_0= ruleContractEvent )
                    {
                    // InternalMyDsl.g:4423:5: (lv_contractEvent_5_0= ruleContractEvent )
                    // InternalMyDsl.g:4424:6: lv_contractEvent_5_0= ruleContractEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getContractEventContractEventParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_contractEvent_5_0=ruleContractEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"contractEvent",
                    							lv_contractEvent_5_0,
                    							"org.xtext.example.mydsl.MyDsl.ContractEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:4443:3: ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) )
                    {
                    // InternalMyDsl.g:4443:3: ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) )
                    // InternalMyDsl.g:4444:4: () ( (lv_powerEvent_7_0= rulePowerEvent ) )
                    {
                    // InternalMyDsl.g:4444:4: ()
                    // InternalMyDsl.g:4445:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPointAtomAccess().getPointAtomPowerEventAction_3_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:4451:4: ( (lv_powerEvent_7_0= rulePowerEvent ) )
                    // InternalMyDsl.g:4452:5: (lv_powerEvent_7_0= rulePowerEvent )
                    {
                    // InternalMyDsl.g:4452:5: (lv_powerEvent_7_0= rulePowerEvent )
                    // InternalMyDsl.g:4453:6: lv_powerEvent_7_0= rulePowerEvent
                    {

                    						newCompositeNode(grammarAccess.getPointAtomAccess().getPowerEventPowerEventParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_powerEvent_7_0=rulePowerEvent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPointAtomRule());
                    						}
                    						set(
                    							current,
                    							"powerEvent",
                    							lv_powerEvent_7_0,
                    							"org.xtext.example.mydsl.MyDsl.PowerEvent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointAtom"


    // $ANTLR start "entryRuleTimevalue"
    // InternalMyDsl.g:4475:1: entryRuleTimevalue returns [EObject current=null] : iv_ruleTimevalue= ruleTimevalue EOF ;
    public final EObject entryRuleTimevalue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimevalue = null;


        try {
            // InternalMyDsl.g:4475:50: (iv_ruleTimevalue= ruleTimevalue EOF )
            // InternalMyDsl.g:4476:2: iv_ruleTimevalue= ruleTimevalue EOF
            {
             newCompositeNode(grammarAccess.getTimevalueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimevalue=ruleTimevalue();

            state._fsp--;

             current =iv_ruleTimevalue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimevalue"


    // $ANTLR start "ruleTimevalue"
    // InternalMyDsl.g:4482:1: ruleTimevalue returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) ) ;
    public final EObject ruleTimevalue() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        EObject lv_variable_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4488:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) ) )
            // InternalMyDsl.g:4489:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) )
            {
            // InternalMyDsl.g:4489:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_INT) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_ID) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalMyDsl.g:4490:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalMyDsl.g:4490:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalMyDsl.g:4491:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalMyDsl.g:4491:4: ()
                    // InternalMyDsl.g:4492:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTimevalueAccess().getTimevalueIntAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:4498:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalMyDsl.g:4499:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalMyDsl.g:4499:5: (lv_value_1_0= RULE_INT )
                    // InternalMyDsl.g:4500:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getTimevalueAccess().getValueINTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimevalueRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4518:3: ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalMyDsl.g:4518:3: ( () ( (lv_variable_3_0= ruleVariableDotExpression ) ) )
                    // InternalMyDsl.g:4519:4: () ( (lv_variable_3_0= ruleVariableDotExpression ) )
                    {
                    // InternalMyDsl.g:4519:4: ()
                    // InternalMyDsl.g:4520:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTimevalueAccess().getTimevalueVariableAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:4526:4: ( (lv_variable_3_0= ruleVariableDotExpression ) )
                    // InternalMyDsl.g:4527:5: (lv_variable_3_0= ruleVariableDotExpression )
                    {
                    // InternalMyDsl.g:4527:5: (lv_variable_3_0= ruleVariableDotExpression )
                    // InternalMyDsl.g:4528:6: lv_variable_3_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getTimevalueAccess().getVariableVariableDotExpressionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_variable_3_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimevalueRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_3_0,
                    							"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimevalue"


    // $ANTLR start "entryRuleTimeUnit"
    // InternalMyDsl.g:4550:1: entryRuleTimeUnit returns [String current=null] : iv_ruleTimeUnit= ruleTimeUnit EOF ;
    public final String entryRuleTimeUnit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimeUnit = null;


        try {
            // InternalMyDsl.g:4550:48: (iv_ruleTimeUnit= ruleTimeUnit EOF )
            // InternalMyDsl.g:4551:2: iv_ruleTimeUnit= ruleTimeUnit EOF
            {
             newCompositeNode(grammarAccess.getTimeUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeUnit=ruleTimeUnit();

            state._fsp--;

             current =iv_ruleTimeUnit.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeUnit"


    // $ANTLR start "ruleTimeUnit"
    // InternalMyDsl.g:4557:1: ruleTimeUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' ) ;
    public final AntlrDatatypeRuleToken ruleTimeUnit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4563:2: ( (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' ) )
            // InternalMyDsl.g:4564:2: (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' )
            {
            // InternalMyDsl.g:4564:2: (kw= 'seconds' | kw= 'minutes' | kw= 'hours' | kw= 'days' | kw= 'weeks' | kw= 'months' | kw= 'years' )
            int alt42=7;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt42=1;
                }
                break;
            case 89:
                {
                alt42=2;
                }
                break;
            case 90:
                {
                alt42=3;
                }
                break;
            case 91:
                {
                alt42=4;
                }
                break;
            case 92:
                {
                alt42=5;
                }
                break;
            case 93:
                {
                alt42=6;
                }
                break;
            case 94:
                {
                alt42=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalMyDsl.g:4565:3: kw= 'seconds'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getSecondsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4571:3: kw= 'minutes'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMinutesKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:4577:3: kw= 'hours'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getHoursKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:4583:3: kw= 'days'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getDaysKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:4589:3: kw= 'weeks'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getWeeksKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:4595:3: kw= 'months'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMonthsKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:4601:3: kw= 'years'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTimeUnitAccess().getYearsKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeUnit"


    // $ANTLR start "entryRuleInterval"
    // InternalMyDsl.g:4610:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // InternalMyDsl.g:4610:49: (iv_ruleInterval= ruleInterval EOF )
            // InternalMyDsl.g:4611:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // InternalMyDsl.g:4617:1: ruleInterval returns [EObject current=null] : ( (lv_intervalExpression_0_0= ruleIntervalExpression ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        EObject lv_intervalExpression_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4623:2: ( ( (lv_intervalExpression_0_0= ruleIntervalExpression ) ) )
            // InternalMyDsl.g:4624:2: ( (lv_intervalExpression_0_0= ruleIntervalExpression ) )
            {
            // InternalMyDsl.g:4624:2: ( (lv_intervalExpression_0_0= ruleIntervalExpression ) )
            // InternalMyDsl.g:4625:3: (lv_intervalExpression_0_0= ruleIntervalExpression )
            {
            // InternalMyDsl.g:4625:3: (lv_intervalExpression_0_0= ruleIntervalExpression )
            // InternalMyDsl.g:4626:4: lv_intervalExpression_0_0= ruleIntervalExpression
            {

            				newCompositeNode(grammarAccess.getIntervalAccess().getIntervalExpressionIntervalExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_intervalExpression_0_0=ruleIntervalExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getIntervalRule());
            				}
            				set(
            					current,
            					"intervalExpression",
            					lv_intervalExpression_0_0,
            					"org.xtext.example.mydsl.MyDsl.IntervalExpression");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleIntervalExpression"
    // InternalMyDsl.g:4646:1: entryRuleIntervalExpression returns [EObject current=null] : iv_ruleIntervalExpression= ruleIntervalExpression EOF ;
    public final EObject entryRuleIntervalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntervalExpression = null;


        try {
            // InternalMyDsl.g:4646:59: (iv_ruleIntervalExpression= ruleIntervalExpression EOF )
            // InternalMyDsl.g:4647:2: iv_ruleIntervalExpression= ruleIntervalExpression EOF
            {
             newCompositeNode(grammarAccess.getIntervalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntervalExpression=ruleIntervalExpression();

            state._fsp--;

             current =iv_ruleIntervalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntervalExpression"


    // $ANTLR start "ruleIntervalExpression"
    // InternalMyDsl.g:4653:1: ruleIntervalExpression returns [EObject current=null] : ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) ) ;
    public final EObject ruleIntervalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_situation_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4659:2: ( ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) ) )
            // InternalMyDsl.g:4660:2: ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) )
            {
            // InternalMyDsl.g:4660:2: ( ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' ) | ( () ( (lv_situation_8_0= ruleSituation ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==95) ) {
                alt43=1;
            }
            else if ( ((LA43_0>=96 && LA43_0<=107)) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalMyDsl.g:4661:3: ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' )
                    {
                    // InternalMyDsl.g:4661:3: ( () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')' )
                    // InternalMyDsl.g:4662:4: () otherlv_1= 'Interval' otherlv_2= '(' ( (lv_arg1_3_0= rulePointExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= rulePointExpression ) ) otherlv_6= ')'
                    {
                    // InternalMyDsl.g:4662:4: ()
                    // InternalMyDsl.g:4663:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIntervalExpressionAccess().getIntervalFunctionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,95,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntervalExpressionAccess().getIntervalKeyword_0_1());
                    			
                    otherlv_2=(Token)match(input,20,FOLLOW_47); 

                    				newLeafNode(otherlv_2, grammarAccess.getIntervalExpressionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalMyDsl.g:4677:4: ( (lv_arg1_3_0= rulePointExpression ) )
                    // InternalMyDsl.g:4678:5: (lv_arg1_3_0= rulePointExpression )
                    {
                    // InternalMyDsl.g:4678:5: (lv_arg1_3_0= rulePointExpression )
                    // InternalMyDsl.g:4679:6: lv_arg1_3_0= rulePointExpression
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getArg1PointExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_arg1_3_0=rulePointExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"org.xtext.example.mydsl.MyDsl.PointExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,21,FOLLOW_47); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntervalExpressionAccess().getCommaKeyword_0_4());
                    			
                    // InternalMyDsl.g:4700:4: ( (lv_arg2_5_0= rulePointExpression ) )
                    // InternalMyDsl.g:4701:5: (lv_arg2_5_0= rulePointExpression )
                    {
                    // InternalMyDsl.g:4701:5: (lv_arg2_5_0= rulePointExpression )
                    // InternalMyDsl.g:4702:6: lv_arg2_5_0= rulePointExpression
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getArg2PointExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_arg2_5_0=rulePointExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"org.xtext.example.mydsl.MyDsl.PointExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getIntervalExpressionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4725:3: ( () ( (lv_situation_8_0= ruleSituation ) ) )
                    {
                    // InternalMyDsl.g:4725:3: ( () ( (lv_situation_8_0= ruleSituation ) ) )
                    // InternalMyDsl.g:4726:4: () ( (lv_situation_8_0= ruleSituation ) )
                    {
                    // InternalMyDsl.g:4726:4: ()
                    // InternalMyDsl.g:4727:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getIntervalExpressionAccess().getSituationExpressionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:4733:4: ( (lv_situation_8_0= ruleSituation ) )
                    // InternalMyDsl.g:4734:5: (lv_situation_8_0= ruleSituation )
                    {
                    // InternalMyDsl.g:4734:5: (lv_situation_8_0= ruleSituation )
                    // InternalMyDsl.g:4735:6: lv_situation_8_0= ruleSituation
                    {

                    						newCompositeNode(grammarAccess.getIntervalExpressionAccess().getSituationSituationParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_situation_8_0=ruleSituation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntervalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"situation",
                    							lv_situation_8_0,
                    							"org.xtext.example.mydsl.MyDsl.Situation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntervalExpression"


    // $ANTLR start "entryRuleSituation"
    // InternalMyDsl.g:4757:1: entryRuleSituation returns [EObject current=null] : iv_ruleSituation= ruleSituation EOF ;
    public final EObject entryRuleSituation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSituation = null;


        try {
            // InternalMyDsl.g:4757:50: (iv_ruleSituation= ruleSituation EOF )
            // InternalMyDsl.g:4758:2: iv_ruleSituation= ruleSituation EOF
            {
             newCompositeNode(grammarAccess.getSituationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSituation=ruleSituation();

            state._fsp--;

             current =iv_ruleSituation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSituation"


    // $ANTLR start "ruleSituation"
    // InternalMyDsl.g:4764:1: ruleSituation returns [EObject current=null] : (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState ) ;
    public final EObject ruleSituation() throws RecognitionException {
        EObject current = null;

        EObject this_ObligationState_0 = null;

        EObject this_ContractState_1 = null;

        EObject this_PowerState_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4770:2: ( (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState ) )
            // InternalMyDsl.g:4771:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )
            {
            // InternalMyDsl.g:4771:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )
            int alt44=3;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // InternalMyDsl.g:4772:3: this_ObligationState_0= ruleObligationState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getObligationStateParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObligationState_0=ruleObligationState();

                    state._fsp--;


                    			current = this_ObligationState_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4781:3: this_ContractState_1= ruleContractState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getContractStateParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContractState_1=ruleContractState();

                    state._fsp--;


                    			current = this_ContractState_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:4790:3: this_PowerState_2= rulePowerState
                    {

                    			newCompositeNode(grammarAccess.getSituationAccess().getPowerStateParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerState_2=rulePowerState();

                    state._fsp--;


                    			current = this_PowerState_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSituation"


    // $ANTLR start "entryRulePowerState"
    // InternalMyDsl.g:4802:1: entryRulePowerState returns [EObject current=null] : iv_rulePowerState= rulePowerState EOF ;
    public final EObject entryRulePowerState() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerState = null;


        try {
            // InternalMyDsl.g:4802:51: (iv_rulePowerState= rulePowerState EOF )
            // InternalMyDsl.g:4803:2: iv_rulePowerState= rulePowerState EOF
            {
             newCompositeNode(grammarAccess.getPowerStateRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerState=rulePowerState();

            state._fsp--;

             current =iv_rulePowerState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerState"


    // $ANTLR start "rulePowerState"
    // InternalMyDsl.g:4809:1: rulePowerState returns [EObject current=null] : ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject rulePowerState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4815:2: ( ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalMyDsl.g:4816:2: ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalMyDsl.g:4816:2: ( ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalMyDsl.g:4817:3: ( (lv_stateName_0_0= rulePowerStateName ) ) otherlv_1= '(' otherlv_2= 'powers.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalMyDsl.g:4817:3: ( (lv_stateName_0_0= rulePowerStateName ) )
            // InternalMyDsl.g:4818:4: (lv_stateName_0_0= rulePowerStateName )
            {
            // InternalMyDsl.g:4818:4: (lv_stateName_0_0= rulePowerStateName )
            // InternalMyDsl.g:4819:5: lv_stateName_0_0= rulePowerStateName
            {

            					newCompositeNode(grammarAccess.getPowerStateAccess().getStateNamePowerStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_stateName_0_0=rulePowerStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"org.xtext.example.mydsl.MyDsl.PowerStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getPowerStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,70,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerStateAccess().getPowersKeyword_2());
            		
            // InternalMyDsl.g:4844:3: ( (otherlv_3= RULE_ID ) )
            // InternalMyDsl.g:4845:4: (otherlv_3= RULE_ID )
            {
            // InternalMyDsl.g:4845:4: (otherlv_3= RULE_ID )
            // InternalMyDsl.g:4846:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerStateRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_3, grammarAccess.getPowerStateAccess().getPowerVariablePowerWrapperCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPowerStateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerState"


    // $ANTLR start "entryRulePowerStateName"
    // InternalMyDsl.g:4865:1: entryRulePowerStateName returns [String current=null] : iv_rulePowerStateName= rulePowerStateName EOF ;
    public final String entryRulePowerStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePowerStateName = null;


        try {
            // InternalMyDsl.g:4865:54: (iv_rulePowerStateName= rulePowerStateName EOF )
            // InternalMyDsl.g:4866:2: iv_rulePowerStateName= rulePowerStateName EOF
            {
             newCompositeNode(grammarAccess.getPowerStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerStateName=rulePowerStateName();

            state._fsp--;

             current =iv_rulePowerStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerStateName"


    // $ANTLR start "rulePowerStateName"
    // InternalMyDsl.g:4872:1: rulePowerStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' ) ;
    public final AntlrDatatypeRuleToken rulePowerStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4878:2: ( (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' ) )
            // InternalMyDsl.g:4879:2: (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' )
            {
            // InternalMyDsl.g:4879:2: (kw= 'Create' | kw= 'UnsuccessfulTermination' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'SuccessfulTermination' )
            int alt45=6;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt45=1;
                }
                break;
            case 97:
                {
                alt45=2;
                }
                break;
            case 98:
                {
                alt45=3;
                }
                break;
            case 99:
                {
                alt45=4;
                }
                break;
            case 100:
                {
                alt45=5;
                }
                break;
            case 101:
                {
                alt45=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalMyDsl.g:4880:3: kw= 'Create'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getCreateKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:4886:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getUnsuccessfulTerminationKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:4892:3: kw= 'Active'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getActiveKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:4898:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getInEffectKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:4904:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getSuspensionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:4910:3: kw= 'SuccessfulTermination'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getPowerStateNameAccess().getSuccessfulTerminationKeyword_5());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerStateName"


    // $ANTLR start "entryRuleObligationState"
    // InternalMyDsl.g:4919:1: entryRuleObligationState returns [EObject current=null] : iv_ruleObligationState= ruleObligationState EOF ;
    public final EObject entryRuleObligationState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligationState = null;


        try {
            // InternalMyDsl.g:4919:56: (iv_ruleObligationState= ruleObligationState EOF )
            // InternalMyDsl.g:4920:2: iv_ruleObligationState= ruleObligationState EOF
            {
             newCompositeNode(grammarAccess.getObligationStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationState=ruleObligationState();

            state._fsp--;

             current =iv_ruleObligationState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationState"


    // $ANTLR start "ruleObligationState"
    // InternalMyDsl.g:4926:1: ruleObligationState returns [EObject current=null] : ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleObligationState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:4932:2: ( ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // InternalMyDsl.g:4933:2: ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // InternalMyDsl.g:4933:2: ( ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // InternalMyDsl.g:4934:3: ( (lv_stateName_0_0= ruleObligationStateName ) ) otherlv_1= '(' otherlv_2= 'obligations.' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // InternalMyDsl.g:4934:3: ( (lv_stateName_0_0= ruleObligationStateName ) )
            // InternalMyDsl.g:4935:4: (lv_stateName_0_0= ruleObligationStateName )
            {
            // InternalMyDsl.g:4935:4: (lv_stateName_0_0= ruleObligationStateName )
            // InternalMyDsl.g:4936:5: lv_stateName_0_0= ruleObligationStateName
            {

            					newCompositeNode(grammarAccess.getObligationStateAccess().getStateNameObligationStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_stateName_0_0=ruleObligationStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"org.xtext.example.mydsl.MyDsl.ObligationStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getObligationStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,78,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getObligationStateAccess().getObligationsKeyword_2());
            		
            // InternalMyDsl.g:4961:3: ( (otherlv_3= RULE_ID ) )
            // InternalMyDsl.g:4962:4: (otherlv_3= RULE_ID )
            {
            // InternalMyDsl.g:4962:4: (otherlv_3= RULE_ID )
            // InternalMyDsl.g:4963:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObligationStateRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_3, grammarAccess.getObligationStateAccess().getObligationVariableObligationWrapperCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getObligationStateAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationState"


    // $ANTLR start "entryRuleObligationStateName"
    // InternalMyDsl.g:4982:1: entryRuleObligationStateName returns [String current=null] : iv_ruleObligationStateName= ruleObligationStateName EOF ;
    public final String entryRuleObligationStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleObligationStateName = null;


        try {
            // InternalMyDsl.g:4982:59: (iv_ruleObligationStateName= ruleObligationStateName EOF )
            // InternalMyDsl.g:4983:2: iv_ruleObligationStateName= ruleObligationStateName EOF
            {
             newCompositeNode(grammarAccess.getObligationStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligationStateName=ruleObligationStateName();

            state._fsp--;

             current =iv_ruleObligationStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligationStateName"


    // $ANTLR start "ruleObligationStateName"
    // InternalMyDsl.g:4989:1: ruleObligationStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' ) ;
    public final AntlrDatatypeRuleToken ruleObligationStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:4995:2: ( (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' ) )
            // InternalMyDsl.g:4996:2: (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' )
            {
            // InternalMyDsl.g:4996:2: (kw= 'Create' | kw= 'Discharge' | kw= 'Active' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Violation' | kw= 'Fulfillment' | kw= 'UnsuccessfulTermination' )
            int alt46=8;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt46=1;
                }
                break;
            case 102:
                {
                alt46=2;
                }
                break;
            case 98:
                {
                alt46=3;
                }
                break;
            case 99:
                {
                alt46=4;
                }
                break;
            case 100:
                {
                alt46=5;
                }
                break;
            case 103:
                {
                alt46=6;
                }
                break;
            case 104:
                {
                alt46=7;
                }
                break;
            case 97:
                {
                alt46=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalMyDsl.g:4997:3: kw= 'Create'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getCreateKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:5003:3: kw= 'Discharge'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getDischargeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:5009:3: kw= 'Active'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getActiveKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:5015:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getInEffectKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:5021:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getSuspensionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:5027:3: kw= 'Violation'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getViolationKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:5033:3: kw= 'Fulfillment'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getFulfillmentKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:5039:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getObligationStateNameAccess().getUnsuccessfulTerminationKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligationStateName"


    // $ANTLR start "entryRuleContractState"
    // InternalMyDsl.g:5048:1: entryRuleContractState returns [EObject current=null] : iv_ruleContractState= ruleContractState EOF ;
    public final EObject entryRuleContractState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractState = null;


        try {
            // InternalMyDsl.g:5048:54: (iv_ruleContractState= ruleContractState EOF )
            // InternalMyDsl.g:5049:2: iv_ruleContractState= ruleContractState EOF
            {
             newCompositeNode(grammarAccess.getContractStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractState=ruleContractState();

            state._fsp--;

             current =iv_ruleContractState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractState"


    // $ANTLR start "ruleContractState"
    // InternalMyDsl.g:5055:1: ruleContractState returns [EObject current=null] : ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' ) ;
    public final EObject ruleContractState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_stateName_0_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:5061:2: ( ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' ) )
            // InternalMyDsl.g:5062:2: ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' )
            {
            // InternalMyDsl.g:5062:2: ( ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')' )
            // InternalMyDsl.g:5063:3: ( (lv_stateName_0_0= ruleContractStateName ) ) otherlv_1= '(' otherlv_2= 'self' otherlv_3= ')'
            {
            // InternalMyDsl.g:5063:3: ( (lv_stateName_0_0= ruleContractStateName ) )
            // InternalMyDsl.g:5064:4: (lv_stateName_0_0= ruleContractStateName )
            {
            // InternalMyDsl.g:5064:4: (lv_stateName_0_0= ruleContractStateName )
            // InternalMyDsl.g:5065:5: lv_stateName_0_0= ruleContractStateName
            {

            					newCompositeNode(grammarAccess.getContractStateAccess().getStateNameContractStateNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_stateName_0_0=ruleContractStateName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractStateRule());
            					}
            					set(
            						current,
            						"stateName",
            						lv_stateName_0_0,
            						"org.xtext.example.mydsl.MyDsl.ContractStateName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_51); 

            			newLeafNode(otherlv_1, grammarAccess.getContractStateAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,82,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getContractStateAccess().getSelfKeyword_2());
            		
            otherlv_3=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getContractStateAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractState"


    // $ANTLR start "entryRuleContractStateName"
    // InternalMyDsl.g:5098:1: entryRuleContractStateName returns [String current=null] : iv_ruleContractStateName= ruleContractStateName EOF ;
    public final String entryRuleContractStateName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractStateName = null;


        try {
            // InternalMyDsl.g:5098:57: (iv_ruleContractStateName= ruleContractStateName EOF )
            // InternalMyDsl.g:5099:2: iv_ruleContractStateName= ruleContractStateName EOF
            {
             newCompositeNode(grammarAccess.getContractStateNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractStateName=ruleContractStateName();

            state._fsp--;

             current =iv_ruleContractStateName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractStateName"


    // $ANTLR start "ruleContractStateName"
    // InternalMyDsl.g:5105:1: ruleContractStateName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' ) ;
    public final AntlrDatatypeRuleToken ruleContractStateName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:5111:2: ( (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' ) )
            // InternalMyDsl.g:5112:2: (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' )
            {
            // InternalMyDsl.g:5112:2: (kw= 'Form' | kw= 'UnAssign' | kw= 'InEffect' | kw= 'Suspension' | kw= 'Rescission' | kw= 'SuccessfulTermination' | kw= 'UnsuccessfulTermination' | kw= 'Active' )
            int alt47=8;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt47=1;
                }
                break;
            case 106:
                {
                alt47=2;
                }
                break;
            case 99:
                {
                alt47=3;
                }
                break;
            case 100:
                {
                alt47=4;
                }
                break;
            case 107:
                {
                alt47=5;
                }
                break;
            case 101:
                {
                alt47=6;
                }
                break;
            case 97:
                {
                alt47=7;
                }
                break;
            case 98:
                {
                alt47=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalMyDsl.g:5113:3: kw= 'Form'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getFormKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:5119:3: kw= 'UnAssign'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getUnAssignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:5125:3: kw= 'InEffect'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getInEffectKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:5131:3: kw= 'Suspension'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getSuspensionKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:5137:3: kw= 'Rescission'
                    {
                    kw=(Token)match(input,107,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getRescissionKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:5143:3: kw= 'SuccessfulTermination'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getSuccessfulTerminationKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:5149:3: kw= 'UnsuccessfulTermination'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getUnsuccessfulTerminationKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:5155:3: kw= 'Active'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateNameAccess().getActiveKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractStateName"


    // $ANTLR start "entryRuleObligation"
    // InternalMyDsl.g:5164:1: entryRuleObligation returns [EObject current=null] : iv_ruleObligation= ruleObligation EOF ;
    public final EObject entryRuleObligation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligation = null;


        try {
            // InternalMyDsl.g:5164:51: (iv_ruleObligation= ruleObligation EOF )
            // InternalMyDsl.g:5165:2: iv_ruleObligation= ruleObligation EOF
            {
             newCompositeNode(grammarAccess.getObligationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligation=ruleObligation();

            state._fsp--;

             current =iv_ruleObligation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligation"


    // $ANTLR start "ruleObligation"
    // InternalMyDsl.g:5171:1: ruleObligation returns [EObject current=null] : ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'O' | otherlv_3= 'Obligation' ) otherlv_4= '(' ( (lv_debtor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= ruleProposition ) ) otherlv_12= ')' ) ;
    public final EObject ruleObligation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_trigger_0_0 = null;

        EObject lv_debtor_5_0 = null;

        EObject lv_creditor_7_0 = null;

        EObject lv_antecedent_9_0 = null;

        EObject lv_consequent_11_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:5177:2: ( ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'O' | otherlv_3= 'Obligation' ) otherlv_4= '(' ( (lv_debtor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= ruleProposition ) ) otherlv_12= ')' ) )
            // InternalMyDsl.g:5178:2: ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'O' | otherlv_3= 'Obligation' ) otherlv_4= '(' ( (lv_debtor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= ruleProposition ) ) otherlv_12= ')' )
            {
            // InternalMyDsl.g:5178:2: ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'O' | otherlv_3= 'Obligation' ) otherlv_4= '(' ( (lv_debtor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= ruleProposition ) ) otherlv_12= ')' )
            // InternalMyDsl.g:5179:3: ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'O' | otherlv_3= 'Obligation' ) otherlv_4= '(' ( (lv_debtor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_creditor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= ruleProposition ) ) otherlv_12= ')'
            {
            // InternalMyDsl.g:5179:3: ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_INT)||LA48_0==20||(LA48_0>=55 && LA48_0<=69)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalMyDsl.g:5180:4: ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->'
                    {
                    // InternalMyDsl.g:5180:4: ( (lv_trigger_0_0= ruleProposition ) )
                    // InternalMyDsl.g:5181:5: (lv_trigger_0_0= ruleProposition )
                    {
                    // InternalMyDsl.g:5181:5: (lv_trigger_0_0= ruleProposition )
                    // InternalMyDsl.g:5182:6: lv_trigger_0_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getObligationAccess().getTriggerPropositionParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_53);
                    lv_trigger_0_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getObligationRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_0_0,
                    							"org.xtext.example.mydsl.MyDsl.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,108,FOLLOW_54); 

                    				newLeafNode(otherlv_1, grammarAccess.getObligationAccess().getHyphenMinusGreaterThanSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:5204:3: (otherlv_2= 'O' | otherlv_3= 'Obligation' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==109) ) {
                alt49=1;
            }
            else if ( (LA49_0==110) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalMyDsl.g:5205:4: otherlv_2= 'O'
                    {
                    otherlv_2=(Token)match(input,109,FOLLOW_12); 

                    				newLeafNode(otherlv_2, grammarAccess.getObligationAccess().getOKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:5210:4: otherlv_3= 'Obligation'
                    {
                    otherlv_3=(Token)match(input,110,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getObligationAccess().getObligationKeyword_1_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FOLLOW_24); 

            			newLeafNode(otherlv_4, grammarAccess.getObligationAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMyDsl.g:5219:3: ( (lv_debtor_5_0= ruleVariableDotExpression ) )
            // InternalMyDsl.g:5220:4: (lv_debtor_5_0= ruleVariableDotExpression )
            {
            // InternalMyDsl.g:5220:4: (lv_debtor_5_0= ruleVariableDotExpression )
            // InternalMyDsl.g:5221:5: lv_debtor_5_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getDebtorVariableDotExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_43);
            lv_debtor_5_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"debtor",
            						lv_debtor_5_0,
            						"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_24); 

            			newLeafNode(otherlv_6, grammarAccess.getObligationAccess().getCommaKeyword_4());
            		
            // InternalMyDsl.g:5242:3: ( (lv_creditor_7_0= ruleVariableDotExpression ) )
            // InternalMyDsl.g:5243:4: (lv_creditor_7_0= ruleVariableDotExpression )
            {
            // InternalMyDsl.g:5243:4: (lv_creditor_7_0= ruleVariableDotExpression )
            // InternalMyDsl.g:5244:5: lv_creditor_7_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getCreditorVariableDotExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_43);
            lv_creditor_7_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"creditor",
            						lv_creditor_7_0,
            						"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,21,FOLLOW_35); 

            			newLeafNode(otherlv_8, grammarAccess.getObligationAccess().getCommaKeyword_6());
            		
            // InternalMyDsl.g:5265:3: ( (lv_antecedent_9_0= ruleProposition ) )
            // InternalMyDsl.g:5266:4: (lv_antecedent_9_0= ruleProposition )
            {
            // InternalMyDsl.g:5266:4: (lv_antecedent_9_0= ruleProposition )
            // InternalMyDsl.g:5267:5: lv_antecedent_9_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getAntecedentPropositionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_43);
            lv_antecedent_9_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_9_0,
            						"org.xtext.example.mydsl.MyDsl.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,21,FOLLOW_35); 

            			newLeafNode(otherlv_10, grammarAccess.getObligationAccess().getCommaKeyword_8());
            		
            // InternalMyDsl.g:5288:3: ( (lv_consequent_11_0= ruleProposition ) )
            // InternalMyDsl.g:5289:4: (lv_consequent_11_0= ruleProposition )
            {
            // InternalMyDsl.g:5289:4: (lv_consequent_11_0= ruleProposition )
            // InternalMyDsl.g:5290:5: lv_consequent_11_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getObligationAccess().getConsequentPropositionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_42);
            lv_consequent_11_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObligationRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_11_0,
            						"org.xtext.example.mydsl.MyDsl.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getObligationAccess().getRightParenthesisKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligation"


    // $ANTLR start "entryRulePower"
    // InternalMyDsl.g:5315:1: entryRulePower returns [EObject current=null] : iv_rulePower= rulePower EOF ;
    public final EObject entryRulePower() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePower = null;


        try {
            // InternalMyDsl.g:5315:46: (iv_rulePower= rulePower EOF )
            // InternalMyDsl.g:5316:2: iv_rulePower= rulePower EOF
            {
             newCompositeNode(grammarAccess.getPowerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePower=rulePower();

            state._fsp--;

             current =iv_rulePower; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePower"


    // $ANTLR start "rulePower"
    // InternalMyDsl.g:5322:1: rulePower returns [EObject current=null] : ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'P' | otherlv_3= 'Power' ) otherlv_4= '(' ( (lv_creditor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= rulePowerFunction ) ) otherlv_12= ')' ) ;
    public final EObject rulePower() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_trigger_0_0 = null;

        EObject lv_creditor_5_0 = null;

        EObject lv_debtor_7_0 = null;

        EObject lv_antecedent_9_0 = null;

        EObject lv_consequent_11_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:5328:2: ( ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'P' | otherlv_3= 'Power' ) otherlv_4= '(' ( (lv_creditor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= rulePowerFunction ) ) otherlv_12= ')' ) )
            // InternalMyDsl.g:5329:2: ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'P' | otherlv_3= 'Power' ) otherlv_4= '(' ( (lv_creditor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= rulePowerFunction ) ) otherlv_12= ')' )
            {
            // InternalMyDsl.g:5329:2: ( ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'P' | otherlv_3= 'Power' ) otherlv_4= '(' ( (lv_creditor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= rulePowerFunction ) ) otherlv_12= ')' )
            // InternalMyDsl.g:5330:3: ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )? (otherlv_2= 'P' | otherlv_3= 'Power' ) otherlv_4= '(' ( (lv_creditor_5_0= ruleVariableDotExpression ) ) otherlv_6= ',' ( (lv_debtor_7_0= ruleVariableDotExpression ) ) otherlv_8= ',' ( (lv_antecedent_9_0= ruleProposition ) ) otherlv_10= ',' ( (lv_consequent_11_0= rulePowerFunction ) ) otherlv_12= ')'
            {
            // InternalMyDsl.g:5330:3: ( ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_ID && LA50_0<=RULE_INT)||LA50_0==20||(LA50_0>=55 && LA50_0<=69)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalMyDsl.g:5331:4: ( (lv_trigger_0_0= ruleProposition ) ) otherlv_1= '->'
                    {
                    // InternalMyDsl.g:5331:4: ( (lv_trigger_0_0= ruleProposition ) )
                    // InternalMyDsl.g:5332:5: (lv_trigger_0_0= ruleProposition )
                    {
                    // InternalMyDsl.g:5332:5: (lv_trigger_0_0= ruleProposition )
                    // InternalMyDsl.g:5333:6: lv_trigger_0_0= ruleProposition
                    {

                    						newCompositeNode(grammarAccess.getPowerAccess().getTriggerPropositionParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_53);
                    lv_trigger_0_0=ruleProposition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPowerRule());
                    						}
                    						set(
                    							current,
                    							"trigger",
                    							lv_trigger_0_0,
                    							"org.xtext.example.mydsl.MyDsl.Proposition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,108,FOLLOW_55); 

                    				newLeafNode(otherlv_1, grammarAccess.getPowerAccess().getHyphenMinusGreaterThanSignKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalMyDsl.g:5355:3: (otherlv_2= 'P' | otherlv_3= 'Power' )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==111) ) {
                alt51=1;
            }
            else if ( (LA51_0==112) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalMyDsl.g:5356:4: otherlv_2= 'P'
                    {
                    otherlv_2=(Token)match(input,111,FOLLOW_12); 

                    				newLeafNode(otherlv_2, grammarAccess.getPowerAccess().getPKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:5361:4: otherlv_3= 'Power'
                    {
                    otherlv_3=(Token)match(input,112,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerAccess().getPowerKeyword_1_1());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FOLLOW_24); 

            			newLeafNode(otherlv_4, grammarAccess.getPowerAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMyDsl.g:5370:3: ( (lv_creditor_5_0= ruleVariableDotExpression ) )
            // InternalMyDsl.g:5371:4: (lv_creditor_5_0= ruleVariableDotExpression )
            {
            // InternalMyDsl.g:5371:4: (lv_creditor_5_0= ruleVariableDotExpression )
            // InternalMyDsl.g:5372:5: lv_creditor_5_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getCreditorVariableDotExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_43);
            lv_creditor_5_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"creditor",
            						lv_creditor_5_0,
            						"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_24); 

            			newLeafNode(otherlv_6, grammarAccess.getPowerAccess().getCommaKeyword_4());
            		
            // InternalMyDsl.g:5393:3: ( (lv_debtor_7_0= ruleVariableDotExpression ) )
            // InternalMyDsl.g:5394:4: (lv_debtor_7_0= ruleVariableDotExpression )
            {
            // InternalMyDsl.g:5394:4: (lv_debtor_7_0= ruleVariableDotExpression )
            // InternalMyDsl.g:5395:5: lv_debtor_7_0= ruleVariableDotExpression
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getDebtorVariableDotExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_43);
            lv_debtor_7_0=ruleVariableDotExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"debtor",
            						lv_debtor_7_0,
            						"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,21,FOLLOW_35); 

            			newLeafNode(otherlv_8, grammarAccess.getPowerAccess().getCommaKeyword_6());
            		
            // InternalMyDsl.g:5416:3: ( (lv_antecedent_9_0= ruleProposition ) )
            // InternalMyDsl.g:5417:4: (lv_antecedent_9_0= ruleProposition )
            {
            // InternalMyDsl.g:5417:4: (lv_antecedent_9_0= ruleProposition )
            // InternalMyDsl.g:5418:5: lv_antecedent_9_0= ruleProposition
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getAntecedentPropositionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_43);
            lv_antecedent_9_0=ruleProposition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"antecedent",
            						lv_antecedent_9_0,
            						"org.xtext.example.mydsl.MyDsl.Proposition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,21,FOLLOW_56); 

            			newLeafNode(otherlv_10, grammarAccess.getPowerAccess().getCommaKeyword_8());
            		
            // InternalMyDsl.g:5439:3: ( (lv_consequent_11_0= rulePowerFunction ) )
            // InternalMyDsl.g:5440:4: (lv_consequent_11_0= rulePowerFunction )
            {
            // InternalMyDsl.g:5440:4: (lv_consequent_11_0= rulePowerFunction )
            // InternalMyDsl.g:5441:5: lv_consequent_11_0= rulePowerFunction
            {

            					newCompositeNode(grammarAccess.getPowerAccess().getConsequentPowerFunctionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_42);
            lv_consequent_11_0=rulePowerFunction();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerRule());
            					}
            					set(
            						current,
            						"consequent",
            						lv_consequent_11_0,
            						"org.xtext.example.mydsl.MyDsl.PowerFunction");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getPowerAccess().getRightParenthesisKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePower"


    // $ANTLR start "entryRulePowerFunction"
    // InternalMyDsl.g:5466:1: entryRulePowerFunction returns [EObject current=null] : iv_rulePowerFunction= rulePowerFunction EOF ;
    public final EObject entryRulePowerFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerFunction = null;


        try {
            // InternalMyDsl.g:5466:54: (iv_rulePowerFunction= rulePowerFunction EOF )
            // InternalMyDsl.g:5467:2: iv_rulePowerFunction= rulePowerFunction EOF
            {
             newCompositeNode(grammarAccess.getPowerFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerFunction=rulePowerFunction();

            state._fsp--;

             current =iv_rulePowerFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerFunction"


    // $ANTLR start "rulePowerFunction"
    // InternalMyDsl.g:5473:1: rulePowerFunction returns [EObject current=null] : ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) ) ;
    public final EObject rulePowerFunction() throws RecognitionException {
        EObject current = null;

        Token lv_action_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_action_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_action_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_action_19_0=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token lv_action_25_0=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token lv_action_31_0=null;
        Token otherlv_32=null;
        Token lv_norm_33_0=null;
        Token otherlv_34=null;
        Token lv_action_36_0=null;
        Token otherlv_37=null;
        Token lv_norm_38_0=null;
        Token otherlv_39=null;
        Token lv_action_41_0=null;
        Token otherlv_42=null;
        Token lv_norm_43_0=null;
        Token otherlv_44=null;


        	enterRule();

        try {
            // InternalMyDsl.g:5479:2: ( ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) ) )
            // InternalMyDsl.g:5480:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )
            {
            // InternalMyDsl.g:5480:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )
            int alt52=8;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalMyDsl.g:5481:3: ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
                    {
                    // InternalMyDsl.g:5481:3: ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' )
                    // InternalMyDsl.g:5482:4: () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')'
                    {
                    // InternalMyDsl.g:5482:4: ()
                    // InternalMyDsl.g:5483:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationSuspendedAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5489:4: ( (lv_action_1_0= 'Suspended' ) )
                    // InternalMyDsl.g:5490:5: (lv_action_1_0= 'Suspended' )
                    {
                    // InternalMyDsl.g:5490:5: (lv_action_1_0= 'Suspended' )
                    // InternalMyDsl.g:5491:6: lv_action_1_0= 'Suspended'
                    {
                    lv_action_1_0=(Token)match(input,73,FOLLOW_12); 

                    						newLeafNode(lv_action_1_0, grammarAccess.getPowerFunctionAccess().getActionSuspendedKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_1_0, "Suspended");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_50); 

                    				newLeafNode(otherlv_2, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    otherlv_3=(Token)match(input,78,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_0_3());
                    			
                    // InternalMyDsl.g:5511:4: ( (otherlv_4= RULE_ID ) )
                    // InternalMyDsl.g:5512:5: (otherlv_4= RULE_ID )
                    {
                    // InternalMyDsl.g:5512:5: (otherlv_4= RULE_ID )
                    // InternalMyDsl.g:5513:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_4, grammarAccess.getPowerFunctionAccess().getNormObligationWrapperCrossReference_0_4_0());
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:5530:3: ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    {
                    // InternalMyDsl.g:5530:3: ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' )
                    // InternalMyDsl.g:5531:4: () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')'
                    {
                    // InternalMyDsl.g:5531:4: ()
                    // InternalMyDsl.g:5532:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationResumedAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5538:4: ( (lv_action_7_0= 'Resumed' ) )
                    // InternalMyDsl.g:5539:5: (lv_action_7_0= 'Resumed' )
                    {
                    // InternalMyDsl.g:5539:5: (lv_action_7_0= 'Resumed' )
                    // InternalMyDsl.g:5540:6: lv_action_7_0= 'Resumed'
                    {
                    lv_action_7_0=(Token)match(input,74,FOLLOW_12); 

                    						newLeafNode(lv_action_7_0, grammarAccess.getPowerFunctionAccess().getActionResumedKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_7_0, "Resumed");
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,20,FOLLOW_50); 

                    				newLeafNode(otherlv_8, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    otherlv_9=(Token)match(input,78,FOLLOW_4); 

                    				newLeafNode(otherlv_9, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_1_3());
                    			
                    // InternalMyDsl.g:5560:4: ( (otherlv_10= RULE_ID ) )
                    // InternalMyDsl.g:5561:5: (otherlv_10= RULE_ID )
                    {
                    // InternalMyDsl.g:5561:5: (otherlv_10= RULE_ID )
                    // InternalMyDsl.g:5562:6: otherlv_10= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_10, grammarAccess.getPowerFunctionAccess().getNormObligationWrapperCrossReference_1_4_0());
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_1_5());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:5579:3: ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' )
                    {
                    // InternalMyDsl.g:5579:3: ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' )
                    // InternalMyDsl.g:5580:4: () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')'
                    {
                    // InternalMyDsl.g:5580:4: ()
                    // InternalMyDsl.g:5581:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationDischargedAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5587:4: ( (lv_action_13_0= 'Discharged' ) )
                    // InternalMyDsl.g:5588:5: (lv_action_13_0= 'Discharged' )
                    {
                    // InternalMyDsl.g:5588:5: (lv_action_13_0= 'Discharged' )
                    // InternalMyDsl.g:5589:6: lv_action_13_0= 'Discharged'
                    {
                    lv_action_13_0=(Token)match(input,79,FOLLOW_12); 

                    						newLeafNode(lv_action_13_0, grammarAccess.getPowerFunctionAccess().getActionDischargedKeyword_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_13_0, "Discharged");
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,20,FOLLOW_50); 

                    				newLeafNode(otherlv_14, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    otherlv_15=(Token)match(input,78,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_2_3());
                    			
                    // InternalMyDsl.g:5609:4: ( (otherlv_16= RULE_ID ) )
                    // InternalMyDsl.g:5610:5: (otherlv_16= RULE_ID )
                    {
                    // InternalMyDsl.g:5610:5: (otherlv_16= RULE_ID )
                    // InternalMyDsl.g:5611:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_16, grammarAccess.getPowerFunctionAccess().getNormObligationWrapperCrossReference_2_4_0());
                    					

                    }


                    }

                    otherlv_17=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_17, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_2_5());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:5628:3: ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' )
                    {
                    // InternalMyDsl.g:5628:3: ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' )
                    // InternalMyDsl.g:5629:4: () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')'
                    {
                    // InternalMyDsl.g:5629:4: ()
                    // InternalMyDsl.g:5630:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationTerminatedAction_3_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5636:4: ( (lv_action_19_0= 'Terminated' ) )
                    // InternalMyDsl.g:5637:5: (lv_action_19_0= 'Terminated' )
                    {
                    // InternalMyDsl.g:5637:5: (lv_action_19_0= 'Terminated' )
                    // InternalMyDsl.g:5638:6: lv_action_19_0= 'Terminated'
                    {
                    lv_action_19_0=(Token)match(input,77,FOLLOW_12); 

                    						newLeafNode(lv_action_19_0, grammarAccess.getPowerFunctionAccess().getActionTerminatedKeyword_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_19_0, "Terminated");
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,20,FOLLOW_50); 

                    				newLeafNode(otherlv_20, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_3_2());
                    			
                    otherlv_21=(Token)match(input,78,FOLLOW_4); 

                    				newLeafNode(otherlv_21, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_3_3());
                    			
                    // InternalMyDsl.g:5658:4: ( (otherlv_22= RULE_ID ) )
                    // InternalMyDsl.g:5659:5: (otherlv_22= RULE_ID )
                    {
                    // InternalMyDsl.g:5659:5: (otherlv_22= RULE_ID )
                    // InternalMyDsl.g:5660:6: otherlv_22= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_22=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_22, grammarAccess.getPowerFunctionAccess().getNormObligationWrapperCrossReference_3_4_0());
                    					

                    }


                    }

                    otherlv_23=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_23, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_3_5());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:5677:3: ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' )
                    {
                    // InternalMyDsl.g:5677:3: ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' )
                    // InternalMyDsl.g:5678:4: () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')'
                    {
                    // InternalMyDsl.g:5678:4: ()
                    // InternalMyDsl.g:5679:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFObligationTriggeredAction_4_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5685:4: ( (lv_action_25_0= 'Triggered' ) )
                    // InternalMyDsl.g:5686:5: (lv_action_25_0= 'Triggered' )
                    {
                    // InternalMyDsl.g:5686:5: (lv_action_25_0= 'Triggered' )
                    // InternalMyDsl.g:5687:6: lv_action_25_0= 'Triggered'
                    {
                    lv_action_25_0=(Token)match(input,71,FOLLOW_12); 

                    						newLeafNode(lv_action_25_0, grammarAccess.getPowerFunctionAccess().getActionTriggeredKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_25_0, "Triggered");
                    					

                    }


                    }

                    otherlv_26=(Token)match(input,20,FOLLOW_50); 

                    				newLeafNode(otherlv_26, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_4_2());
                    			
                    otherlv_27=(Token)match(input,78,FOLLOW_4); 

                    				newLeafNode(otherlv_27, grammarAccess.getPowerFunctionAccess().getObligationsKeyword_4_3());
                    			
                    // InternalMyDsl.g:5707:4: ( (otherlv_28= RULE_ID ) )
                    // InternalMyDsl.g:5708:5: (otherlv_28= RULE_ID )
                    {
                    // InternalMyDsl.g:5708:5: (otherlv_28= RULE_ID )
                    // InternalMyDsl.g:5709:6: otherlv_28= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    					
                    otherlv_28=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(otherlv_28, grammarAccess.getPowerFunctionAccess().getNormObligationWrapperCrossReference_4_4_0());
                    					

                    }


                    }

                    otherlv_29=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_29, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_4_5());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:5726:3: ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' )
                    {
                    // InternalMyDsl.g:5726:3: ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' )
                    // InternalMyDsl.g:5727:4: () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')'
                    {
                    // InternalMyDsl.g:5727:4: ()
                    // InternalMyDsl.g:5728:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractSuspendedAction_5_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5734:4: ( (lv_action_31_0= 'Suspended' ) )
                    // InternalMyDsl.g:5735:5: (lv_action_31_0= 'Suspended' )
                    {
                    // InternalMyDsl.g:5735:5: (lv_action_31_0= 'Suspended' )
                    // InternalMyDsl.g:5736:6: lv_action_31_0= 'Suspended'
                    {
                    lv_action_31_0=(Token)match(input,73,FOLLOW_12); 

                    						newLeafNode(lv_action_31_0, grammarAccess.getPowerFunctionAccess().getActionSuspendedKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_31_0, "Suspended");
                    					

                    }


                    }

                    otherlv_32=(Token)match(input,20,FOLLOW_51); 

                    				newLeafNode(otherlv_32, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalMyDsl.g:5752:4: ( (lv_norm_33_0= 'self' ) )
                    // InternalMyDsl.g:5753:5: (lv_norm_33_0= 'self' )
                    {
                    // InternalMyDsl.g:5753:5: (lv_norm_33_0= 'self' )
                    // InternalMyDsl.g:5754:6: lv_norm_33_0= 'self'
                    {
                    lv_norm_33_0=(Token)match(input,82,FOLLOW_42); 

                    						newLeafNode(lv_norm_33_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_5_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_33_0, "self");
                    					

                    }


                    }

                    otherlv_34=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_34, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_5_4());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:5772:3: ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' )
                    {
                    // InternalMyDsl.g:5772:3: ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' )
                    // InternalMyDsl.g:5773:4: () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')'
                    {
                    // InternalMyDsl.g:5773:4: ()
                    // InternalMyDsl.g:5774:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractResumedAction_6_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5780:4: ( (lv_action_36_0= 'Resumed' ) )
                    // InternalMyDsl.g:5781:5: (lv_action_36_0= 'Resumed' )
                    {
                    // InternalMyDsl.g:5781:5: (lv_action_36_0= 'Resumed' )
                    // InternalMyDsl.g:5782:6: lv_action_36_0= 'Resumed'
                    {
                    lv_action_36_0=(Token)match(input,74,FOLLOW_12); 

                    						newLeafNode(lv_action_36_0, grammarAccess.getPowerFunctionAccess().getActionResumedKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_36_0, "Resumed");
                    					

                    }


                    }

                    otherlv_37=(Token)match(input,20,FOLLOW_51); 

                    				newLeafNode(otherlv_37, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_6_2());
                    			
                    // InternalMyDsl.g:5798:4: ( (lv_norm_38_0= 'self' ) )
                    // InternalMyDsl.g:5799:5: (lv_norm_38_0= 'self' )
                    {
                    // InternalMyDsl.g:5799:5: (lv_norm_38_0= 'self' )
                    // InternalMyDsl.g:5800:6: lv_norm_38_0= 'self'
                    {
                    lv_norm_38_0=(Token)match(input,82,FOLLOW_42); 

                    						newLeafNode(lv_norm_38_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_6_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_38_0, "self");
                    					

                    }


                    }

                    otherlv_39=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_39, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_6_4());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:5818:3: ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' )
                    {
                    // InternalMyDsl.g:5818:3: ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' )
                    // InternalMyDsl.g:5819:4: () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')'
                    {
                    // InternalMyDsl.g:5819:4: ()
                    // InternalMyDsl.g:5820:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPowerFunctionAccess().getPFContractTerminatedAction_7_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:5826:4: ( (lv_action_41_0= 'Terminated' ) )
                    // InternalMyDsl.g:5827:5: (lv_action_41_0= 'Terminated' )
                    {
                    // InternalMyDsl.g:5827:5: (lv_action_41_0= 'Terminated' )
                    // InternalMyDsl.g:5828:6: lv_action_41_0= 'Terminated'
                    {
                    lv_action_41_0=(Token)match(input,77,FOLLOW_12); 

                    						newLeafNode(lv_action_41_0, grammarAccess.getPowerFunctionAccess().getActionTerminatedKeyword_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "action", lv_action_41_0, "Terminated");
                    					

                    }


                    }

                    otherlv_42=(Token)match(input,20,FOLLOW_51); 

                    				newLeafNode(otherlv_42, grammarAccess.getPowerFunctionAccess().getLeftParenthesisKeyword_7_2());
                    			
                    // InternalMyDsl.g:5844:4: ( (lv_norm_43_0= 'self' ) )
                    // InternalMyDsl.g:5845:5: (lv_norm_43_0= 'self' )
                    {
                    // InternalMyDsl.g:5845:5: (lv_norm_43_0= 'self' )
                    // InternalMyDsl.g:5846:6: lv_norm_43_0= 'self'
                    {
                    lv_norm_43_0=(Token)match(input,82,FOLLOW_42); 

                    						newLeafNode(lv_norm_43_0, grammarAccess.getPowerFunctionAccess().getNormSelfKeyword_7_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPowerFunctionRule());
                    						}
                    						setWithLastConsumed(current, "norm", lv_norm_43_0, "self");
                    					

                    }


                    }

                    otherlv_44=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_44, grammarAccess.getPowerFunctionAccess().getRightParenthesisKeyword_7_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerFunction"


    // $ANTLR start "entryRuleVariableDotExpression"
    // InternalMyDsl.g:5867:1: entryRuleVariableDotExpression returns [EObject current=null] : iv_ruleVariableDotExpression= ruleVariableDotExpression EOF ;
    public final EObject entryRuleVariableDotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDotExpression = null;


        try {
            // InternalMyDsl.g:5867:62: (iv_ruleVariableDotExpression= ruleVariableDotExpression EOF )
            // InternalMyDsl.g:5868:2: iv_ruleVariableDotExpression= ruleVariableDotExpression EOF
            {
             newCompositeNode(grammarAccess.getVariableDotExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDotExpression=ruleVariableDotExpression();

            state._fsp--;

             current =iv_ruleVariableDotExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDotExpression"


    // $ANTLR start "ruleVariableDotExpression"
    // InternalMyDsl.g:5874:1: ruleVariableDotExpression returns [EObject current=null] : (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (lv_tail_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleVariableDotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_tail_3_0=null;
        EObject this_VariableRef_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:5880:2: ( (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (lv_tail_3_0= RULE_ID ) ) )* ) )
            // InternalMyDsl.g:5881:2: (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (lv_tail_3_0= RULE_ID ) ) )* )
            {
            // InternalMyDsl.g:5881:2: (this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (lv_tail_3_0= RULE_ID ) ) )* )
            // InternalMyDsl.g:5882:3: this_VariableRef_0= ruleVariableRef ( () otherlv_2= '.' ( (lv_tail_3_0= RULE_ID ) ) )*
            {

            			newCompositeNode(grammarAccess.getVariableDotExpressionAccess().getVariableRefParserRuleCall_0());
            		
            pushFollow(FOLLOW_57);
            this_VariableRef_0=ruleVariableRef();

            state._fsp--;


            			current = this_VariableRef_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:5890:3: ( () otherlv_2= '.' ( (lv_tail_3_0= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==16) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalMyDsl.g:5891:4: () otherlv_2= '.' ( (lv_tail_3_0= RULE_ID ) )
            	    {
            	    // InternalMyDsl.g:5891:4: ()
            	    // InternalMyDsl.g:5892:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getVariableDotExpressionAccess().getVariableDotExpressionRefAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,16,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getVariableDotExpressionAccess().getFullStopKeyword_1_1());
            	    			
            	    // InternalMyDsl.g:5902:4: ( (lv_tail_3_0= RULE_ID ) )
            	    // InternalMyDsl.g:5903:5: (lv_tail_3_0= RULE_ID )
            	    {
            	    // InternalMyDsl.g:5903:5: (lv_tail_3_0= RULE_ID )
            	    // InternalMyDsl.g:5904:6: lv_tail_3_0= RULE_ID
            	    {
            	    lv_tail_3_0=(Token)match(input,RULE_ID,FOLLOW_57); 

            	    						newLeafNode(lv_tail_3_0, grammarAccess.getVariableDotExpressionAccess().getTailIDTerminalRuleCall_1_2_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getVariableDotExpressionRule());
            	    						}
            	    						setWithLastConsumed(
            	    							current,
            	    							"tail",
            	    							lv_tail_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDotExpression"


    // $ANTLR start "entryRuleVariableRef"
    // InternalMyDsl.g:5925:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalMyDsl.g:5925:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalMyDsl.g:5926:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalMyDsl.g:5932:1: ruleVariableRef returns [EObject current=null] : ( () ( (lv_variable_1_0= RULE_ID ) ) ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token lv_variable_1_0=null;


        	enterRule();

        try {
            // InternalMyDsl.g:5938:2: ( ( () ( (lv_variable_1_0= RULE_ID ) ) ) )
            // InternalMyDsl.g:5939:2: ( () ( (lv_variable_1_0= RULE_ID ) ) )
            {
            // InternalMyDsl.g:5939:2: ( () ( (lv_variable_1_0= RULE_ID ) ) )
            // InternalMyDsl.g:5940:3: () ( (lv_variable_1_0= RULE_ID ) )
            {
            // InternalMyDsl.g:5940:3: ()
            // InternalMyDsl.g:5941:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableRefAccess().getVariableRefAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:5947:3: ( (lv_variable_1_0= RULE_ID ) )
            // InternalMyDsl.g:5948:4: (lv_variable_1_0= RULE_ID )
            {
            // InternalMyDsl.g:5948:4: (lv_variable_1_0= RULE_ID )
            // InternalMyDsl.g:5949:5: lv_variable_1_0= RULE_ID
            {
            lv_variable_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_variable_1_0, grammarAccess.getVariableRefAccess().getVariableIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleExpression"
    // InternalMyDsl.g:5969:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalMyDsl.g:5969:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalMyDsl.g:5970:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalMyDsl.g:5976:1: ruleExpression returns [EObject current=null] : this_Or_0= ruleOr ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Or_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:5982:2: (this_Or_0= ruleOr )
            // InternalMyDsl.g:5983:2: this_Or_0= ruleOr
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getOrParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Or_0=ruleOr();

            state._fsp--;


            		current = this_Or_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalMyDsl.g:5994:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalMyDsl.g:5994:43: (iv_ruleOr= ruleOr EOF )
            // InternalMyDsl.g:5995:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalMyDsl.g:6001:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6007:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalMyDsl.g:6008:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalMyDsl.g:6008:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalMyDsl.g:6009:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
            		
            pushFollow(FOLLOW_38);
            this_And_0=ruleAnd();

            state._fsp--;


            			current = this_And_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:6017:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==47) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalMyDsl.g:6018:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalMyDsl.g:6018:4: ()
            	    // InternalMyDsl.g:6019:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,47,FOLLOW_24); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	    			
            	    // InternalMyDsl.g:6029:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalMyDsl.g:6030:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalMyDsl.g:6030:5: (lv_right_3_0= ruleAnd )
            	    // InternalMyDsl.g:6031:6: lv_right_3_0= ruleAnd
            	    {

            	    						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_38);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.And");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalMyDsl.g:6053:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalMyDsl.g:6053:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalMyDsl.g:6054:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalMyDsl.g:6060:1: ruleAnd returns [EObject current=null] : (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Equality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6066:2: ( (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) )
            // InternalMyDsl.g:6067:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            {
            // InternalMyDsl.g:6067:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            // InternalMyDsl.g:6068:3: this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0());
            		
            pushFollow(FOLLOW_39);
            this_Equality_0=ruleEquality();

            state._fsp--;


            			current = this_Equality_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:6076:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==48) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalMyDsl.g:6077:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) )
            	    {
            	    // InternalMyDsl.g:6077:4: ()
            	    // InternalMyDsl.g:6078:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,48,FOLLOW_24); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	    			
            	    // InternalMyDsl.g:6088:4: ( (lv_right_3_0= ruleEquality ) )
            	    // InternalMyDsl.g:6089:5: (lv_right_3_0= ruleEquality )
            	    {
            	    // InternalMyDsl.g:6089:5: (lv_right_3_0= ruleEquality )
            	    // InternalMyDsl.g:6090:6: lv_right_3_0= ruleEquality
            	    {

            	    						newCompositeNode(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=ruleEquality();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.Equality");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalMyDsl.g:6112:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // InternalMyDsl.g:6112:49: (iv_ruleEquality= ruleEquality EOF )
            // InternalMyDsl.g:6113:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalMyDsl.g:6119:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6125:2: ( (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalMyDsl.g:6126:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalMyDsl.g:6126:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalMyDsl.g:6127:3: this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {

            			newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0());
            		
            pushFollow(FOLLOW_40);
            this_Comparison_0=ruleComparison();

            state._fsp--;


            			current = this_Comparison_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:6135:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=49 && LA57_0<=50)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalMyDsl.g:6136:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalMyDsl.g:6136:4: ()
            	    // InternalMyDsl.g:6137:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMyDsl.g:6143:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalMyDsl.g:6144:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalMyDsl.g:6144:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalMyDsl.g:6145:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalMyDsl.g:6145:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt56=2;
            	    int LA56_0 = input.LA(1);

            	    if ( (LA56_0==49) ) {
            	        alt56=1;
            	    }
            	    else if ( (LA56_0==50) ) {
            	        alt56=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 56, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt56) {
            	        case 1 :
            	            // InternalMyDsl.g:6146:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,49,FOLLOW_24); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:6157:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,50,FOLLOW_24); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyDsl.g:6170:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalMyDsl.g:6171:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalMyDsl.g:6171:5: (lv_right_3_0= ruleComparison )
            	    // InternalMyDsl.g:6172:6: lv_right_3_0= ruleComparison
            	    {

            	    						newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEqualityRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.Comparison");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalMyDsl.g:6194:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalMyDsl.g:6194:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalMyDsl.g:6195:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalMyDsl.g:6201:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6207:2: ( (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // InternalMyDsl.g:6208:2: (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // InternalMyDsl.g:6208:2: (this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // InternalMyDsl.g:6209:3: this_Addition_0= ruleAddition ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {

            			newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0());
            		
            pushFollow(FOLLOW_41);
            this_Addition_0=ruleAddition();

            state._fsp--;


            			current = this_Addition_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:6217:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( ((LA59_0>=51 && LA59_0<=54)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalMyDsl.g:6218:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // InternalMyDsl.g:6218:4: ()
            	    // InternalMyDsl.g:6219:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalMyDsl.g:6225:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalMyDsl.g:6226:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalMyDsl.g:6226:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalMyDsl.g:6227:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalMyDsl.g:6227:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt58=4;
            	    switch ( input.LA(1) ) {
            	    case 51:
            	        {
            	        alt58=1;
            	        }
            	        break;
            	    case 52:
            	        {
            	        alt58=2;
            	        }
            	        break;
            	    case 53:
            	        {
            	        alt58=3;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt58=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 58, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt58) {
            	        case 1 :
            	            // InternalMyDsl.g:6228:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,51,FOLLOW_24); 

            	            							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:6239:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,52,FOLLOW_24); 

            	            							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalMyDsl.g:6250:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,53,FOLLOW_24); 

            	            							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalMyDsl.g:6261:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,54,FOLLOW_24); 

            	            							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonRule());
            	            							}
            	            							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMyDsl.g:6274:4: ( (lv_right_3_0= ruleAddition ) )
            	    // InternalMyDsl.g:6275:5: (lv_right_3_0= ruleAddition )
            	    {
            	    // InternalMyDsl.g:6275:5: (lv_right_3_0= ruleAddition )
            	    // InternalMyDsl.g:6276:6: lv_right_3_0= ruleAddition
            	    {

            	    						newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_right_3_0=ruleAddition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.xtext.example.mydsl.MyDsl.Addition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // InternalMyDsl.g:6298:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalMyDsl.g:6298:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalMyDsl.g:6299:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalMyDsl.g:6305:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6311:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalMyDsl.g:6312:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalMyDsl.g:6312:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalMyDsl.g:6313:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_58);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:6321:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==27||LA61_0==113) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalMyDsl.g:6322:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalMyDsl.g:6322:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==27) ) {
            	        alt60=1;
            	    }
            	    else if ( (LA60_0==113) ) {
            	        alt60=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 60, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // InternalMyDsl.g:6323:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalMyDsl.g:6323:5: ( () otherlv_2= '+' )
            	            // InternalMyDsl.g:6324:6: () otherlv_2= '+'
            	            {
            	            // InternalMyDsl.g:6324:6: ()
            	            // InternalMyDsl.g:6325:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,27,FOLLOW_24); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:6337:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalMyDsl.g:6337:5: ( () otherlv_4= '-' )
            	            // InternalMyDsl.g:6338:6: () otherlv_4= '-'
            	            {
            	            // InternalMyDsl.g:6338:6: ()
            	            // InternalMyDsl.g:6339:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,113,FOLLOW_24); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMyDsl.g:6351:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalMyDsl.g:6352:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalMyDsl.g:6352:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalMyDsl.g:6353:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_58);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"org.xtext.example.mydsl.MyDsl.Multiplication");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalMyDsl.g:6375:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalMyDsl.g:6375:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalMyDsl.g:6376:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalMyDsl.g:6382:1: ruleMultiplication returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6388:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* ) )
            // InternalMyDsl.g:6389:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            {
            // InternalMyDsl.g:6389:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )* )
            // InternalMyDsl.g:6390:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_59);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalMyDsl.g:6398:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==15||LA63_0==114) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalMyDsl.g:6399:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= rulePrimaryExpression ) )
            	    {
            	    // InternalMyDsl.g:6399:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt62=2;
            	    int LA62_0 = input.LA(1);

            	    if ( (LA62_0==15) ) {
            	        alt62=1;
            	    }
            	    else if ( (LA62_0==114) ) {
            	        alt62=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 62, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt62) {
            	        case 1 :
            	            // InternalMyDsl.g:6400:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalMyDsl.g:6400:5: ( () otherlv_2= '*' )
            	            // InternalMyDsl.g:6401:6: () otherlv_2= '*'
            	            {
            	            // InternalMyDsl.g:6401:6: ()
            	            // InternalMyDsl.g:6402:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,15,FOLLOW_24); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalMyDsl.g:6414:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalMyDsl.g:6414:5: ( () otherlv_4= '/' )
            	            // InternalMyDsl.g:6415:6: () otherlv_4= '/'
            	            {
            	            // InternalMyDsl.g:6415:6: ()
            	            // InternalMyDsl.g:6416:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,114,FOLLOW_24); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalMyDsl.g:6428:4: ( (lv_right_5_0= rulePrimaryExpression ) )
            	    // InternalMyDsl.g:6429:5: (lv_right_5_0= rulePrimaryExpression )
            	    {
            	    // InternalMyDsl.g:6429:5: (lv_right_5_0= rulePrimaryExpression )
            	    // InternalMyDsl.g:6430:6: lv_right_5_0= rulePrimaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_right_5_0=rulePrimaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"org.xtext.example.mydsl.MyDsl.PrimaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalMyDsl.g:6452:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalMyDsl.g:6452:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalMyDsl.g:6453:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalMyDsl.g:6459:1: rulePrimaryExpression returns [EObject current=null] : ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_inner_2_0 = null;

        EObject lv_function_5_0 = null;

        EObject lv_expression_8_0 = null;

        EObject this_AtomicExpression_9 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6465:2: ( ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression ) )
            // InternalMyDsl.g:6466:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression )
            {
            // InternalMyDsl.g:6466:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( () ( (lv_function_5_0= ruleFunctionCall ) ) ) | ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) ) | this_AtomicExpression_9= ruleAtomicExpression )
            int alt64=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt64=1;
                }
                break;
            case 87:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
                {
                alt64=2;
                }
                break;
            case 55:
                {
                alt64=3;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case 56:
            case 57:
            case 61:
                {
                alt64=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalMyDsl.g:6467:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalMyDsl.g:6467:3: ( () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalMyDsl.g:6468:4: () otherlv_1= '(' ( (lv_inner_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    // InternalMyDsl.g:6468:4: ()
                    // InternalMyDsl.g:6469:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionRecursiveAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,20,FOLLOW_24); 

                    				newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1());
                    			
                    // InternalMyDsl.g:6479:4: ( (lv_inner_2_0= ruleExpression ) )
                    // InternalMyDsl.g:6480:5: (lv_inner_2_0= ruleExpression )
                    {
                    // InternalMyDsl.g:6480:5: (lv_inner_2_0= ruleExpression )
                    // InternalMyDsl.g:6481:6: lv_inner_2_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getInnerExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_inner_2_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"inner",
                    							lv_inner_2_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:6504:3: ( () ( (lv_function_5_0= ruleFunctionCall ) ) )
                    {
                    // InternalMyDsl.g:6504:3: ( () ( (lv_function_5_0= ruleFunctionCall ) ) )
                    // InternalMyDsl.g:6505:4: () ( (lv_function_5_0= ruleFunctionCall ) )
                    {
                    // InternalMyDsl.g:6505:4: ()
                    // InternalMyDsl.g:6506:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionFunctionCallAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6512:4: ( (lv_function_5_0= ruleFunctionCall ) )
                    // InternalMyDsl.g:6513:5: (lv_function_5_0= ruleFunctionCall )
                    {
                    // InternalMyDsl.g:6513:5: (lv_function_5_0= ruleFunctionCall )
                    // InternalMyDsl.g:6514:6: lv_function_5_0= ruleFunctionCall
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionFunctionCallParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_function_5_0=ruleFunctionCall();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"function",
                    							lv_function_5_0,
                    							"org.xtext.example.mydsl.MyDsl.FunctionCall");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:6533:3: ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) )
                    {
                    // InternalMyDsl.g:6533:3: ( () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) ) )
                    // InternalMyDsl.g:6534:4: () otherlv_7= 'not' ( (lv_expression_8_0= rulePrimaryExpression ) )
                    {
                    // InternalMyDsl.g:6534:4: ()
                    // InternalMyDsl.g:6535:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNegatedPrimaryExpressionAction_2_0(),
                    						current);
                    				

                    }

                    otherlv_7=(Token)match(input,55,FOLLOW_24); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getNotKeyword_2_1());
                    			
                    // InternalMyDsl.g:6545:4: ( (lv_expression_8_0= rulePrimaryExpression ) )
                    // InternalMyDsl.g:6546:5: (lv_expression_8_0= rulePrimaryExpression )
                    {
                    // InternalMyDsl.g:6546:5: (lv_expression_8_0= rulePrimaryExpression )
                    // InternalMyDsl.g:6547:6: lv_expression_8_0= rulePrimaryExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionPrimaryExpressionParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_8_0=rulePrimaryExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_8_0,
                    							"org.xtext.example.mydsl.MyDsl.PrimaryExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:6566:3: this_AtomicExpression_9= ruleAtomicExpression
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAtomicExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicExpression_9=ruleAtomicExpression();

                    state._fsp--;


                    			current = this_AtomicExpression_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleAtomicExpression"
    // InternalMyDsl.g:6578:1: entryRuleAtomicExpression returns [EObject current=null] : iv_ruleAtomicExpression= ruleAtomicExpression EOF ;
    public final EObject entryRuleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpression = null;


        try {
            // InternalMyDsl.g:6578:57: (iv_ruleAtomicExpression= ruleAtomicExpression EOF )
            // InternalMyDsl.g:6579:2: iv_ruleAtomicExpression= ruleAtomicExpression EOF
            {
             newCompositeNode(grammarAccess.getAtomicExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicExpression=ruleAtomicExpression();

            state._fsp--;

             current =iv_ruleAtomicExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicExpression"


    // $ANTLR start "ruleAtomicExpression"
    // InternalMyDsl.g:6585:1: ruleAtomicExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) ) ;
    public final EObject ruleAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_7_0=null;
        Token lv_enumeration_11_0=null;
        Token otherlv_12=null;
        Token lv_enumItem_13_0=null;
        Token otherlv_14=null;
        Token lv_value_16_0=null;
        AntlrDatatypeRuleToken lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_value_9_0 = null;

        EObject lv_value_18_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6591:2: ( ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) ) )
            // InternalMyDsl.g:6592:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )
            {
            // InternalMyDsl.g:6592:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )
            int alt65=8;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // InternalMyDsl.g:6593:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    {
                    // InternalMyDsl.g:6593:3: ( () ( (lv_value_1_0= 'true' ) ) )
                    // InternalMyDsl.g:6594:4: () ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalMyDsl.g:6594:4: ()
                    // InternalMyDsl.g:6595:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionTrueAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6601:4: ( (lv_value_1_0= 'true' ) )
                    // InternalMyDsl.g:6602:5: (lv_value_1_0= 'true' )
                    {
                    // InternalMyDsl.g:6602:5: (lv_value_1_0= 'true' )
                    // InternalMyDsl.g:6603:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,56,FOLLOW_2); 

                    						newLeafNode(lv_value_1_0, grammarAccess.getAtomicExpressionAccess().getValueTrueKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_0, "true");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:6617:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    {
                    // InternalMyDsl.g:6617:3: ( () ( (lv_value_3_0= 'false' ) ) )
                    // InternalMyDsl.g:6618:4: () ( (lv_value_3_0= 'false' ) )
                    {
                    // InternalMyDsl.g:6618:4: ()
                    // InternalMyDsl.g:6619:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionFalseAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6625:4: ( (lv_value_3_0= 'false' ) )
                    // InternalMyDsl.g:6626:5: (lv_value_3_0= 'false' )
                    {
                    // InternalMyDsl.g:6626:5: (lv_value_3_0= 'false' )
                    // InternalMyDsl.g:6627:6: lv_value_3_0= 'false'
                    {
                    lv_value_3_0=(Token)match(input,57,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getAtomicExpressionAccess().getValueFalseKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_3_0, "false");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:6641:3: ( () ( (lv_value_5_0= ruleDouble ) ) )
                    {
                    // InternalMyDsl.g:6641:3: ( () ( (lv_value_5_0= ruleDouble ) ) )
                    // InternalMyDsl.g:6642:4: () ( (lv_value_5_0= ruleDouble ) )
                    {
                    // InternalMyDsl.g:6642:4: ()
                    // InternalMyDsl.g:6643:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionDoubleAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6649:4: ( (lv_value_5_0= ruleDouble ) )
                    // InternalMyDsl.g:6650:5: (lv_value_5_0= ruleDouble )
                    {
                    // InternalMyDsl.g:6650:5: (lv_value_5_0= ruleDouble )
                    // InternalMyDsl.g:6651:6: lv_value_5_0= ruleDouble
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueDoubleParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleDouble();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"org.xtext.example.mydsl.MyDsl.Double");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:6670:3: ( () ( (lv_value_7_0= RULE_INT ) ) )
                    {
                    // InternalMyDsl.g:6670:3: ( () ( (lv_value_7_0= RULE_INT ) ) )
                    // InternalMyDsl.g:6671:4: () ( (lv_value_7_0= RULE_INT ) )
                    {
                    // InternalMyDsl.g:6671:4: ()
                    // InternalMyDsl.g:6672:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionIntAction_3_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6678:4: ( (lv_value_7_0= RULE_INT ) )
                    // InternalMyDsl.g:6679:5: (lv_value_7_0= RULE_INT )
                    {
                    // InternalMyDsl.g:6679:5: (lv_value_7_0= RULE_INT )
                    // InternalMyDsl.g:6680:6: lv_value_7_0= RULE_INT
                    {
                    lv_value_7_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_7_0, grammarAccess.getAtomicExpressionAccess().getValueINTTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_7_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:6698:3: ( () ( (lv_value_9_0= ruleDate ) ) )
                    {
                    // InternalMyDsl.g:6698:3: ( () ( (lv_value_9_0= ruleDate ) ) )
                    // InternalMyDsl.g:6699:4: () ( (lv_value_9_0= ruleDate ) )
                    {
                    // InternalMyDsl.g:6699:4: ()
                    // InternalMyDsl.g:6700:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionDateAction_4_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6706:4: ( (lv_value_9_0= ruleDate ) )
                    // InternalMyDsl.g:6707:5: (lv_value_9_0= ruleDate )
                    {
                    // InternalMyDsl.g:6707:5: (lv_value_9_0= ruleDate )
                    // InternalMyDsl.g:6708:6: lv_value_9_0= ruleDate
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueDateParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_9_0=ruleDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_9_0,
                    							"org.xtext.example.mydsl.MyDsl.Date");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:6727:3: ( () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')' )
                    {
                    // InternalMyDsl.g:6727:3: ( () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')' )
                    // InternalMyDsl.g:6728:4: () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')'
                    {
                    // InternalMyDsl.g:6728:4: ()
                    // InternalMyDsl.g:6729:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionEnumAction_5_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6735:4: ( (lv_enumeration_11_0= RULE_ID ) )
                    // InternalMyDsl.g:6736:5: (lv_enumeration_11_0= RULE_ID )
                    {
                    // InternalMyDsl.g:6736:5: (lv_enumeration_11_0= RULE_ID )
                    // InternalMyDsl.g:6737:6: lv_enumeration_11_0= RULE_ID
                    {
                    lv_enumeration_11_0=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(lv_enumeration_11_0, grammarAccess.getAtomicExpressionAccess().getEnumerationIDTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"enumeration",
                    							lv_enumeration_11_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_12, grammarAccess.getAtomicExpressionAccess().getLeftParenthesisKeyword_5_2());
                    			
                    // InternalMyDsl.g:6757:4: ( (lv_enumItem_13_0= RULE_ID ) )
                    // InternalMyDsl.g:6758:5: (lv_enumItem_13_0= RULE_ID )
                    {
                    // InternalMyDsl.g:6758:5: (lv_enumItem_13_0= RULE_ID )
                    // InternalMyDsl.g:6759:6: lv_enumItem_13_0= RULE_ID
                    {
                    lv_enumItem_13_0=(Token)match(input,RULE_ID,FOLLOW_42); 

                    						newLeafNode(lv_enumItem_13_0, grammarAccess.getAtomicExpressionAccess().getEnumItemIDTerminalRuleCall_5_3_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"enumItem",
                    							lv_enumItem_13_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_14=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_14, grammarAccess.getAtomicExpressionAccess().getRightParenthesisKeyword_5_4());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:6781:3: ( () ( (lv_value_16_0= RULE_STRING ) ) )
                    {
                    // InternalMyDsl.g:6781:3: ( () ( (lv_value_16_0= RULE_STRING ) ) )
                    // InternalMyDsl.g:6782:4: () ( (lv_value_16_0= RULE_STRING ) )
                    {
                    // InternalMyDsl.g:6782:4: ()
                    // InternalMyDsl.g:6783:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionStringAction_6_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6789:4: ( (lv_value_16_0= RULE_STRING ) )
                    // InternalMyDsl.g:6790:5: (lv_value_16_0= RULE_STRING )
                    {
                    // InternalMyDsl.g:6790:5: (lv_value_16_0= RULE_STRING )
                    // InternalMyDsl.g:6791:6: lv_value_16_0= RULE_STRING
                    {
                    lv_value_16_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_16_0, grammarAccess.getAtomicExpressionAccess().getValueSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_16_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:6809:3: ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) )
                    {
                    // InternalMyDsl.g:6809:3: ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) )
                    // InternalMyDsl.g:6810:4: () ( (lv_value_18_0= ruleVariableDotExpression ) )
                    {
                    // InternalMyDsl.g:6810:4: ()
                    // InternalMyDsl.g:6811:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getAtomicExpressionAccess().getAtomicExpressionParameterAction_7_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6817:4: ( (lv_value_18_0= ruleVariableDotExpression ) )
                    // InternalMyDsl.g:6818:5: (lv_value_18_0= ruleVariableDotExpression )
                    {
                    // InternalMyDsl.g:6818:5: (lv_value_18_0= ruleVariableDotExpression )
                    // InternalMyDsl.g:6819:6: lv_value_18_0= ruleVariableDotExpression
                    {

                    						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getValueVariableDotExpressionParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_18_0=ruleVariableDotExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_18_0,
                    							"org.xtext.example.mydsl.MyDsl.VariableDotExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicExpression"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalMyDsl.g:6841:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalMyDsl.g:6841:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalMyDsl.g:6842:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalMyDsl.g:6848:1: ruleFunctionCall returns [EObject current=null] : (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject this_MathFunction_0 = null;

        EObject this_StringFunction_1 = null;

        EObject this_DateFunction_2 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6854:2: ( (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction ) )
            // InternalMyDsl.g:6855:2: (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction )
            {
            // InternalMyDsl.g:6855:2: (this_MathFunction_0= ruleMathFunction | this_StringFunction_1= ruleStringFunction | this_DateFunction_2= ruleDateFunction )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
                {
                alt66=1;
                }
                break;
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
                {
                alt66=2;
                }
                break;
            case 87:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalMyDsl.g:6856:3: this_MathFunction_0= ruleMathFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getMathFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathFunction_0=ruleMathFunction();

                    state._fsp--;


                    			current = this_MathFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:6865:3: this_StringFunction_1= ruleStringFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getStringFunctionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringFunction_1=ruleStringFunction();

                    state._fsp--;


                    			current = this_StringFunction_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:6874:3: this_DateFunction_2= ruleDateFunction
                    {

                    			newCompositeNode(grammarAccess.getFunctionCallAccess().getDateFunctionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateFunction_2=ruleDateFunction();

                    state._fsp--;


                    			current = this_DateFunction_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleMathFunction"
    // InternalMyDsl.g:6886:1: entryRuleMathFunction returns [EObject current=null] : iv_ruleMathFunction= ruleMathFunction EOF ;
    public final EObject entryRuleMathFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathFunction = null;


        try {
            // InternalMyDsl.g:6886:53: (iv_ruleMathFunction= ruleMathFunction EOF )
            // InternalMyDsl.g:6887:2: iv_ruleMathFunction= ruleMathFunction EOF
            {
             newCompositeNode(grammarAccess.getMathFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathFunction=ruleMathFunction();

            state._fsp--;

             current =iv_ruleMathFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMathFunction"


    // $ANTLR start "ruleMathFunction"
    // InternalMyDsl.g:6893:1: ruleMathFunction returns [EObject current=null] : ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) ) ;
    public final EObject ruleMathFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_name_8_1=null;
        Token lv_name_8_2=null;
        Token lv_name_8_3=null;
        Token lv_name_8_4=null;
        Token lv_name_8_5=null;
        Token lv_name_8_6=null;
        Token lv_name_8_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_arg1_10_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:6899:2: ( ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) ) )
            // InternalMyDsl.g:6900:2: ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            {
            // InternalMyDsl.g:6900:2: ( ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' ) | ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==115) ) {
                alt68=1;
            }
            else if ( ((LA68_0>=116 && LA68_0<=122)) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalMyDsl.g:6901:3: ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalMyDsl.g:6901:3: ( () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalMyDsl.g:6902:4: () ( (lv_name_1_0= 'Math.pow' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    // InternalMyDsl.g:6902:4: ()
                    // InternalMyDsl.g:6903:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMathFunctionAccess().getTwoArgMathFunctionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6909:4: ( (lv_name_1_0= 'Math.pow' ) )
                    // InternalMyDsl.g:6910:5: (lv_name_1_0= 'Math.pow' )
                    {
                    // InternalMyDsl.g:6910:5: (lv_name_1_0= 'Math.pow' )
                    // InternalMyDsl.g:6911:6: lv_name_1_0= 'Math.pow'
                    {
                    lv_name_1_0=(Token)match(input,115,FOLLOW_12); 

                    						newLeafNode(lv_name_1_0, grammarAccess.getMathFunctionAccess().getNameMathPowKeyword_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMathFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_0, "Math.pow");
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_24); 

                    				newLeafNode(otherlv_2, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalMyDsl.g:6927:4: ( (lv_arg1_3_0= ruleExpression ) )
                    // InternalMyDsl.g:6928:5: (lv_arg1_3_0= ruleExpression )
                    {
                    // InternalMyDsl.g:6928:5: (lv_arg1_3_0= ruleExpression )
                    // InternalMyDsl.g:6929:6: lv_arg1_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg1ExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_arg1_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,21,FOLLOW_24); 

                    				newLeafNode(otherlv_4, grammarAccess.getMathFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalMyDsl.g:6950:4: ( (lv_arg2_5_0= ruleExpression ) )
                    // InternalMyDsl.g:6951:5: (lv_arg2_5_0= ruleExpression )
                    {
                    // InternalMyDsl.g:6951:5: (lv_arg2_5_0= ruleExpression )
                    // InternalMyDsl.g:6952:6: lv_arg2_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg2ExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_arg2_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getMathFunctionAccess().getRightParenthesisKeyword_0_6());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:6975:3: ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' )
                    {
                    // InternalMyDsl.g:6975:3: ( () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')' )
                    // InternalMyDsl.g:6976:4: () ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) ) otherlv_9= '(' ( (lv_arg1_10_0= ruleExpression ) ) otherlv_11= ')'
                    {
                    // InternalMyDsl.g:6976:4: ()
                    // InternalMyDsl.g:6977:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getMathFunctionAccess().getOneArgMathFunctionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:6983:4: ( ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) ) )
                    // InternalMyDsl.g:6984:5: ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) )
                    {
                    // InternalMyDsl.g:6984:5: ( (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' ) )
                    // InternalMyDsl.g:6985:6: (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' )
                    {
                    // InternalMyDsl.g:6985:6: (lv_name_8_1= 'Math.abs' | lv_name_8_2= 'Math.floor' | lv_name_8_3= 'Math.cbrt' | lv_name_8_4= 'Math.ceil' | lv_name_8_5= 'Math.exp' | lv_name_8_6= 'Math.sign' | lv_name_8_7= 'Math.sqrt' )
                    int alt67=7;
                    switch ( input.LA(1) ) {
                    case 116:
                        {
                        alt67=1;
                        }
                        break;
                    case 117:
                        {
                        alt67=2;
                        }
                        break;
                    case 118:
                        {
                        alt67=3;
                        }
                        break;
                    case 119:
                        {
                        alt67=4;
                        }
                        break;
                    case 120:
                        {
                        alt67=5;
                        }
                        break;
                    case 121:
                        {
                        alt67=6;
                        }
                        break;
                    case 122:
                        {
                        alt67=7;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }

                    switch (alt67) {
                        case 1 :
                            // InternalMyDsl.g:6986:7: lv_name_8_1= 'Math.abs'
                            {
                            lv_name_8_1=(Token)match(input,116,FOLLOW_12); 

                            							newLeafNode(lv_name_8_1, grammarAccess.getMathFunctionAccess().getNameMathAbsKeyword_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalMyDsl.g:6997:7: lv_name_8_2= 'Math.floor'
                            {
                            lv_name_8_2=(Token)match(input,117,FOLLOW_12); 

                            							newLeafNode(lv_name_8_2, grammarAccess.getMathFunctionAccess().getNameMathFloorKeyword_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalMyDsl.g:7008:7: lv_name_8_3= 'Math.cbrt'
                            {
                            lv_name_8_3=(Token)match(input,118,FOLLOW_12); 

                            							newLeafNode(lv_name_8_3, grammarAccess.getMathFunctionAccess().getNameMathCbrtKeyword_1_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalMyDsl.g:7019:7: lv_name_8_4= 'Math.ceil'
                            {
                            lv_name_8_4=(Token)match(input,119,FOLLOW_12); 

                            							newLeafNode(lv_name_8_4, grammarAccess.getMathFunctionAccess().getNameMathCeilKeyword_1_1_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalMyDsl.g:7030:7: lv_name_8_5= 'Math.exp'
                            {
                            lv_name_8_5=(Token)match(input,120,FOLLOW_12); 

                            							newLeafNode(lv_name_8_5, grammarAccess.getMathFunctionAccess().getNameMathExpKeyword_1_1_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_5, null);
                            						

                            }
                            break;
                        case 6 :
                            // InternalMyDsl.g:7041:7: lv_name_8_6= 'Math.sign'
                            {
                            lv_name_8_6=(Token)match(input,121,FOLLOW_12); 

                            							newLeafNode(lv_name_8_6, grammarAccess.getMathFunctionAccess().getNameMathSignKeyword_1_1_0_5());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_6, null);
                            						

                            }
                            break;
                        case 7 :
                            // InternalMyDsl.g:7052:7: lv_name_8_7= 'Math.sqrt'
                            {
                            lv_name_8_7=(Token)match(input,122,FOLLOW_12); 

                            							newLeafNode(lv_name_8_7, grammarAccess.getMathFunctionAccess().getNameMathSqrtKeyword_1_1_0_6());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getMathFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_8_7, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_24); 

                    				newLeafNode(otherlv_9, grammarAccess.getMathFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMyDsl.g:7069:4: ( (lv_arg1_10_0= ruleExpression ) )
                    // InternalMyDsl.g:7070:5: (lv_arg1_10_0= ruleExpression )
                    {
                    // InternalMyDsl.g:7070:5: (lv_arg1_10_0= ruleExpression )
                    // InternalMyDsl.g:7071:6: lv_arg1_10_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMathFunctionAccess().getArg1ExpressionParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_arg1_10_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMathFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_10_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_11, grammarAccess.getMathFunctionAccess().getRightParenthesisKeyword_1_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathFunction"


    // $ANTLR start "entryRuleStringFunction"
    // InternalMyDsl.g:7097:1: entryRuleStringFunction returns [EObject current=null] : iv_ruleStringFunction= ruleStringFunction EOF ;
    public final EObject entryRuleStringFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringFunction = null;


        try {
            // InternalMyDsl.g:7097:55: (iv_ruleStringFunction= ruleStringFunction EOF )
            // InternalMyDsl.g:7098:2: iv_ruleStringFunction= ruleStringFunction EOF
            {
             newCompositeNode(grammarAccess.getStringFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringFunction=ruleStringFunction();

            state._fsp--;

             current =iv_ruleStringFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringFunction"


    // $ANTLR start "ruleStringFunction"
    // InternalMyDsl.g:7104:1: ruleStringFunction returns [EObject current=null] : ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) ) ;
    public final EObject ruleStringFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_name_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_name_17_1=null;
        Token lv_name_17_2=null;
        Token lv_name_17_3=null;
        Token lv_name_17_4=null;
        Token lv_name_17_5=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;

        EObject lv_arg3_7_0 = null;

        EObject lv_arg1_12_0 = null;

        EObject lv_arg2_14_0 = null;

        EObject lv_arg1_19_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:7110:2: ( ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) ) )
            // InternalMyDsl.g:7111:2: ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) )
            {
            // InternalMyDsl.g:7111:2: ( ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' ) | ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' ) | ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' ) )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 123:
            case 124:
                {
                alt71=1;
                }
                break;
            case 125:
                {
                alt71=2;
                }
                break;
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
                {
                alt71=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // InternalMyDsl.g:7112:3: ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // InternalMyDsl.g:7112:3: ( () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // InternalMyDsl.g:7113:4: () ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_arg3_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    // InternalMyDsl.g:7113:4: ()
                    // InternalMyDsl.g:7114:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getThreeArgStringFunctionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:7120:4: ( ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) ) )
                    // InternalMyDsl.g:7121:5: ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) )
                    {
                    // InternalMyDsl.g:7121:5: ( (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' ) )
                    // InternalMyDsl.g:7122:6: (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' )
                    {
                    // InternalMyDsl.g:7122:6: (lv_name_1_1= 'String.substring' | lv_name_1_2= 'String.replaceAll' )
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==123) ) {
                        alt69=1;
                    }
                    else if ( (LA69_0==124) ) {
                        alt69=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 0, input);

                        throw nvae;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalMyDsl.g:7123:7: lv_name_1_1= 'String.substring'
                            {
                            lv_name_1_1=(Token)match(input,123,FOLLOW_12); 

                            							newLeafNode(lv_name_1_1, grammarAccess.getStringFunctionAccess().getNameStringSubstringKeyword_0_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalMyDsl.g:7134:7: lv_name_1_2= 'String.replaceAll'
                            {
                            lv_name_1_2=(Token)match(input,124,FOLLOW_12); 

                            							newLeafNode(lv_name_1_2, grammarAccess.getStringFunctionAccess().getNameStringReplaceAllKeyword_0_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_1_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_24); 

                    				newLeafNode(otherlv_2, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_0_2());
                    			
                    // InternalMyDsl.g:7151:4: ( (lv_arg1_3_0= ruleExpression ) )
                    // InternalMyDsl.g:7152:5: (lv_arg1_3_0= ruleExpression )
                    {
                    // InternalMyDsl.g:7152:5: (lv_arg1_3_0= ruleExpression )
                    // InternalMyDsl.g:7153:6: lv_arg1_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_arg1_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_3_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,21,FOLLOW_24); 

                    				newLeafNode(otherlv_4, grammarAccess.getStringFunctionAccess().getCommaKeyword_0_4());
                    			
                    // InternalMyDsl.g:7174:4: ( (lv_arg2_5_0= ruleExpression ) )
                    // InternalMyDsl.g:7175:5: (lv_arg2_5_0= ruleExpression )
                    {
                    // InternalMyDsl.g:7175:5: (lv_arg2_5_0= ruleExpression )
                    // InternalMyDsl.g:7176:6: lv_arg2_5_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg2ExpressionParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_arg2_5_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_5_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,21,FOLLOW_24); 

                    				newLeafNode(otherlv_6, grammarAccess.getStringFunctionAccess().getCommaKeyword_0_6());
                    			
                    // InternalMyDsl.g:7197:4: ( (lv_arg3_7_0= ruleExpression ) )
                    // InternalMyDsl.g:7198:5: (lv_arg3_7_0= ruleExpression )
                    {
                    // InternalMyDsl.g:7198:5: (lv_arg3_7_0= ruleExpression )
                    // InternalMyDsl.g:7199:6: lv_arg3_7_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg3ExpressionParserRuleCall_0_7_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_arg3_7_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg3",
                    							lv_arg3_7_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_8=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_8, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_0_8());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:7222:3: ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' )
                    {
                    // InternalMyDsl.g:7222:3: ( () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')' )
                    // InternalMyDsl.g:7223:4: () ( (lv_name_10_0= 'String.concat' ) ) otherlv_11= '(' ( (lv_arg1_12_0= ruleExpression ) ) otherlv_13= ',' ( (lv_arg2_14_0= ruleExpression ) ) otherlv_15= ')'
                    {
                    // InternalMyDsl.g:7223:4: ()
                    // InternalMyDsl.g:7224:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getTwoArgStringFunctionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:7230:4: ( (lv_name_10_0= 'String.concat' ) )
                    // InternalMyDsl.g:7231:5: (lv_name_10_0= 'String.concat' )
                    {
                    // InternalMyDsl.g:7231:5: (lv_name_10_0= 'String.concat' )
                    // InternalMyDsl.g:7232:6: lv_name_10_0= 'String.concat'
                    {
                    lv_name_10_0=(Token)match(input,125,FOLLOW_12); 

                    						newLeafNode(lv_name_10_0, grammarAccess.getStringFunctionAccess().getNameStringConcatKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStringFunctionRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_10_0, "String.concat");
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,20,FOLLOW_24); 

                    				newLeafNode(otherlv_11, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_1_2());
                    			
                    // InternalMyDsl.g:7248:4: ( (lv_arg1_12_0= ruleExpression ) )
                    // InternalMyDsl.g:7249:5: (lv_arg1_12_0= ruleExpression )
                    {
                    // InternalMyDsl.g:7249:5: (lv_arg1_12_0= ruleExpression )
                    // InternalMyDsl.g:7250:6: lv_arg1_12_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_43);
                    lv_arg1_12_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_12_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_13=(Token)match(input,21,FOLLOW_24); 

                    				newLeafNode(otherlv_13, grammarAccess.getStringFunctionAccess().getCommaKeyword_1_4());
                    			
                    // InternalMyDsl.g:7271:4: ( (lv_arg2_14_0= ruleExpression ) )
                    // InternalMyDsl.g:7272:5: (lv_arg2_14_0= ruleExpression )
                    {
                    // InternalMyDsl.g:7272:5: (lv_arg2_14_0= ruleExpression )
                    // InternalMyDsl.g:7273:6: lv_arg2_14_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg2ExpressionParserRuleCall_1_5_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_arg2_14_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg2",
                    							lv_arg2_14_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_15=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_15, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_1_6());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:7296:3: ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' )
                    {
                    // InternalMyDsl.g:7296:3: ( () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')' )
                    // InternalMyDsl.g:7297:4: () ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) ) otherlv_18= '(' ( (lv_arg1_19_0= ruleExpression ) ) otherlv_20= ')'
                    {
                    // InternalMyDsl.g:7297:4: ()
                    // InternalMyDsl.g:7298:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getStringFunctionAccess().getOneArgStringFunctionAction_2_0(),
                    						current);
                    				

                    }

                    // InternalMyDsl.g:7304:4: ( ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) ) )
                    // InternalMyDsl.g:7305:5: ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) )
                    {
                    // InternalMyDsl.g:7305:5: ( (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' ) )
                    // InternalMyDsl.g:7306:6: (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' )
                    {
                    // InternalMyDsl.g:7306:6: (lv_name_17_1= 'String.toLowerCase' | lv_name_17_2= 'String.toUpperCase' | lv_name_17_3= 'String.trimEnd' | lv_name_17_4= 'String.trimStart' | lv_name_17_5= 'String.trim' )
                    int alt70=5;
                    switch ( input.LA(1) ) {
                    case 126:
                        {
                        alt70=1;
                        }
                        break;
                    case 127:
                        {
                        alt70=2;
                        }
                        break;
                    case 128:
                        {
                        alt70=3;
                        }
                        break;
                    case 129:
                        {
                        alt70=4;
                        }
                        break;
                    case 130:
                        {
                        alt70=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // InternalMyDsl.g:7307:7: lv_name_17_1= 'String.toLowerCase'
                            {
                            lv_name_17_1=(Token)match(input,126,FOLLOW_12); 

                            							newLeafNode(lv_name_17_1, grammarAccess.getStringFunctionAccess().getNameStringToLowerCaseKeyword_2_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalMyDsl.g:7318:7: lv_name_17_2= 'String.toUpperCase'
                            {
                            lv_name_17_2=(Token)match(input,127,FOLLOW_12); 

                            							newLeafNode(lv_name_17_2, grammarAccess.getStringFunctionAccess().getNameStringToUpperCaseKeyword_2_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_2, null);
                            						

                            }
                            break;
                        case 3 :
                            // InternalMyDsl.g:7329:7: lv_name_17_3= 'String.trimEnd'
                            {
                            lv_name_17_3=(Token)match(input,128,FOLLOW_12); 

                            							newLeafNode(lv_name_17_3, grammarAccess.getStringFunctionAccess().getNameStringTrimEndKeyword_2_1_0_2());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_3, null);
                            						

                            }
                            break;
                        case 4 :
                            // InternalMyDsl.g:7340:7: lv_name_17_4= 'String.trimStart'
                            {
                            lv_name_17_4=(Token)match(input,129,FOLLOW_12); 

                            							newLeafNode(lv_name_17_4, grammarAccess.getStringFunctionAccess().getNameStringTrimStartKeyword_2_1_0_3());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_4, null);
                            						

                            }
                            break;
                        case 5 :
                            // InternalMyDsl.g:7351:7: lv_name_17_5= 'String.trim'
                            {
                            lv_name_17_5=(Token)match(input,130,FOLLOW_12); 

                            							newLeafNode(lv_name_17_5, grammarAccess.getStringFunctionAccess().getNameStringTrimKeyword_2_1_0_4());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStringFunctionRule());
                            							}
                            							setWithLastConsumed(current, "name", lv_name_17_5, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    otherlv_18=(Token)match(input,20,FOLLOW_24); 

                    				newLeafNode(otherlv_18, grammarAccess.getStringFunctionAccess().getLeftParenthesisKeyword_2_2());
                    			
                    // InternalMyDsl.g:7368:4: ( (lv_arg1_19_0= ruleExpression ) )
                    // InternalMyDsl.g:7369:5: (lv_arg1_19_0= ruleExpression )
                    {
                    // InternalMyDsl.g:7369:5: (lv_arg1_19_0= ruleExpression )
                    // InternalMyDsl.g:7370:6: lv_arg1_19_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getStringFunctionAccess().getArg1ExpressionParserRuleCall_2_3_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_arg1_19_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStringFunctionRule());
                    						}
                    						set(
                    							current,
                    							"arg1",
                    							lv_arg1_19_0,
                    							"org.xtext.example.mydsl.MyDsl.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_20=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_20, grammarAccess.getStringFunctionAccess().getRightParenthesisKeyword_2_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringFunction"


    // $ANTLR start "entryRuleDateFunction"
    // InternalMyDsl.g:7396:1: entryRuleDateFunction returns [EObject current=null] : iv_ruleDateFunction= ruleDateFunction EOF ;
    public final EObject entryRuleDateFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateFunction = null;


        try {
            // InternalMyDsl.g:7396:53: (iv_ruleDateFunction= ruleDateFunction EOF )
            // InternalMyDsl.g:7397:2: iv_ruleDateFunction= ruleDateFunction EOF
            {
             newCompositeNode(grammarAccess.getDateFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateFunction=ruleDateFunction();

            state._fsp--;

             current =iv_ruleDateFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateFunction"


    // $ANTLR start "ruleDateFunction"
    // InternalMyDsl.g:7403:1: ruleDateFunction returns [EObject current=null] : ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) ;
    public final EObject ruleDateFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_arg1_3_0 = null;

        EObject lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_timeUnit_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:7409:2: ( ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' ) )
            // InternalMyDsl.g:7410:2: ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            {
            // InternalMyDsl.g:7410:2: ( () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')' )
            // InternalMyDsl.g:7411:3: () ( (lv_name_1_0= 'Date.add' ) ) otherlv_2= '(' ( (lv_arg1_3_0= ruleExpression ) ) otherlv_4= ',' ( (lv_value_5_0= ruleExpression ) ) otherlv_6= ',' ( (lv_timeUnit_7_0= ruleTimeUnit ) ) otherlv_8= ')'
            {
            // InternalMyDsl.g:7411:3: ()
            // InternalMyDsl.g:7412:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDateFunctionAccess().getThreeArgDateFunctionAction_0(),
            					current);
            			

            }

            // InternalMyDsl.g:7418:3: ( (lv_name_1_0= 'Date.add' ) )
            // InternalMyDsl.g:7419:4: (lv_name_1_0= 'Date.add' )
            {
            // InternalMyDsl.g:7419:4: (lv_name_1_0= 'Date.add' )
            // InternalMyDsl.g:7420:5: lv_name_1_0= 'Date.add'
            {
            lv_name_1_0=(Token)match(input,87,FOLLOW_12); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDateFunctionAccess().getNameDateAddKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDateFunctionRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "Date.add");
            				

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_24); 

            			newLeafNode(otherlv_2, grammarAccess.getDateFunctionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMyDsl.g:7436:3: ( (lv_arg1_3_0= ruleExpression ) )
            // InternalMyDsl.g:7437:4: (lv_arg1_3_0= ruleExpression )
            {
            // InternalMyDsl.g:7437:4: (lv_arg1_3_0= ruleExpression )
            // InternalMyDsl.g:7438:5: lv_arg1_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getArg1ExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_43);
            lv_arg1_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"arg1",
            						lv_arg1_3_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_24); 

            			newLeafNode(otherlv_4, grammarAccess.getDateFunctionAccess().getCommaKeyword_4());
            		
            // InternalMyDsl.g:7459:3: ( (lv_value_5_0= ruleExpression ) )
            // InternalMyDsl.g:7460:4: (lv_value_5_0= ruleExpression )
            {
            // InternalMyDsl.g:7460:4: (lv_value_5_0= ruleExpression )
            // InternalMyDsl.g:7461:5: lv_value_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getValueExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_43);
            lv_value_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"org.xtext.example.mydsl.MyDsl.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_52); 

            			newLeafNode(otherlv_6, grammarAccess.getDateFunctionAccess().getCommaKeyword_6());
            		
            // InternalMyDsl.g:7482:3: ( (lv_timeUnit_7_0= ruleTimeUnit ) )
            // InternalMyDsl.g:7483:4: (lv_timeUnit_7_0= ruleTimeUnit )
            {
            // InternalMyDsl.g:7483:4: (lv_timeUnit_7_0= ruleTimeUnit )
            // InternalMyDsl.g:7484:5: lv_timeUnit_7_0= ruleTimeUnit
            {

            					newCompositeNode(grammarAccess.getDateFunctionAccess().getTimeUnitTimeUnitParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_42);
            lv_timeUnit_7_0=ruleTimeUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDateFunctionRule());
            					}
            					set(
            						current,
            						"timeUnit",
            						lv_timeUnit_7_0,
            						"org.xtext.example.mydsl.MyDsl.TimeUnit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getDateFunctionAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateFunction"

    // Delegated rules


    protected DFA32 dfa32 = new DFA32(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA65 dfa65 = new DFA65(this);
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\5\uffff\1\13\2\uffff\1\16\6\uffff";
    static final String dfa_3s = "\1\4\4\uffff\1\4\2\uffff\1\4\6\uffff";
    static final String dfa_4s = "\1\105\4\uffff\1\154\2\uffff\1\154\6\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\1\uffff\1\13\1\14\1\6\1\5\1\11\1\12";
    static final String dfa_6s = "\17\uffff}>";
    static final String[] dfa_7s = {
            "\1\5\1\11\1\10\15\uffff\1\1\42\uffff\1\2\1\6\1\7\3\4\1\12\10\3",
            "",
            "",
            "",
            "",
            "\4\13\5\uffff\1\13\2\uffff\1\13\3\uffff\1\14\2\13\1\uffff\2\13\17\uffff\16\13\65\uffff\1\13",
            "",
            "",
            "\4\16\5\uffff\1\16\2\uffff\1\15\4\uffff\2\16\1\uffff\2\16\17\uffff\16\16\65\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2380:2: ( ( () otherlv_1= '(' ( (lv_inner_2_0= ruleProposition ) ) otherlv_3= ')' ) | ( () otherlv_5= 'not' ( (lv_negated_6_0= rulePAtomicExpression ) ) ) | ( () ( (lv_predicateFunction_8_0= rulePredicateFunction ) ) ) | ( () ( (lv_function_10_0= ruleOtherFunction ) ) ) | ( () ( (lv_enumeration_12_0= RULE_ID ) ) otherlv_13= '(' ( (lv_enumItem_14_0= RULE_ID ) ) otherlv_15= ')' ) | ( () ( (lv_variable_17_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_value_19_0= 'true' ) ) ) | ( () ( (lv_value_21_0= 'false' ) ) ) | ( () ( (lv_value_23_0= ruleDouble ) ) ) | ( () ( (lv_value_25_0= RULE_INT ) ) ) | ( () ( (lv_value_27_0= RULE_STRING ) ) ) | ( () ( (lv_value_29_0= ruleDate ) ) ) )";
        }
    }
    static final String dfa_8s = "\15\uffff";
    static final String dfa_9s = "\1\4\1\uffff\4\24\1\uffff\2\24\2\uffff\2\106";
    static final String dfa_10s = "\1\126\1\uffff\4\24\1\uffff\2\24\2\uffff\1\116\1\122";
    static final String dfa_11s = "\1\uffff\1\1\4\uffff\1\2\2\uffff\1\3\1\4\2\uffff";
    static final String dfa_12s = "\15\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\102\uffff\1\2\1\3\1\4\1\5\1\12\1\7\1\10\1\uffff\3\6\1\uffff\4\11",
            "",
            "\1\13",
            "\1\14",
            "\1\14",
            "\1\14",
            "",
            "\1\13",
            "\1\14",
            "",
            "",
            "\1\12\7\uffff\1\6",
            "\1\12\7\uffff\1\6\3\uffff\1\11"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "3649:2: (this_VariableEvent_0= ruleVariableEvent | this_ObligationEvent_1= ruleObligationEvent | this_ContractEvent_2= ruleContractEvent | this_PowerEvent_3= rulePowerEvent )";
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "4355:2: ( ( () ( (lv_variable_1_0= ruleVariableDotExpression ) ) ) | ( () ( (lv_obligationEvent_3_0= ruleObligationEvent ) ) ) | ( () ( (lv_contractEvent_5_0= ruleContractEvent ) ) ) | ( () ( (lv_powerEvent_7_0= rulePowerEvent ) ) ) )";
        }
    }
    static final String dfa_14s = "\1\140\1\24\1\uffff\4\24\1\uffff\1\24\3\106\1\uffff";
    static final String dfa_15s = "\1\153\1\24\1\uffff\4\24\1\uffff\1\24\1\116\2\122\1\uffff";
    static final String dfa_16s = "\2\uffff\1\1\4\uffff\1\2\4\uffff\1\3";
    static final String[] dfa_17s = {
            "\1\1\1\6\1\3\1\4\1\5\1\10\3\2\3\7",
            "\1\11",
            "",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "",
            "\1\13",
            "\1\14\7\uffff\1\2",
            "\1\14\7\uffff\1\2\3\uffff\1\7",
            "\1\14\13\uffff\1\7",
            ""
    };
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[][] dfa_17 = unpackEncodedStringArray(dfa_17s);

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_12;
            this.transition = dfa_17;
        }
        public String getDescription() {
            return "4771:2: (this_ObligationState_0= ruleObligationState | this_ContractState_1= ruleContractState | this_PowerState_2= rulePowerState )";
        }
    }
    static final String dfa_18s = "\1\107\2\24\1\uffff\1\24\1\uffff\3\116\6\uffff";
    static final String dfa_19s = "\1\117\2\24\1\uffff\1\24\1\uffff\3\122\6\uffff";
    static final String dfa_20s = "\3\uffff\1\3\1\uffff\1\5\3\uffff\1\6\1\1\1\2\1\7\1\4\1\10";
    static final String[] dfa_21s = {
            "\1\5\1\uffff\1\1\1\2\2\uffff\1\4\1\uffff\1\3",
            "\1\6",
            "\1\7",
            "",
            "\1\10",
            "",
            "\1\12\3\uffff\1\11",
            "\1\13\3\uffff\1\14",
            "\1\15\3\uffff\1\16",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final char[] dfa_19 = DFA.unpackEncodedStringToUnsignedChars(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_18;
            this.max = dfa_19;
            this.accept = dfa_20;
            this.special = dfa_6;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "5480:2: ( ( () ( (lv_action_1_0= 'Suspended' ) ) otherlv_2= '(' otherlv_3= 'obligations.' ( (otherlv_4= RULE_ID ) ) otherlv_5= ')' ) | ( () ( (lv_action_7_0= 'Resumed' ) ) otherlv_8= '(' otherlv_9= 'obligations.' ( (otherlv_10= RULE_ID ) ) otherlv_11= ')' ) | ( () ( (lv_action_13_0= 'Discharged' ) ) otherlv_14= '(' otherlv_15= 'obligations.' ( (otherlv_16= RULE_ID ) ) otherlv_17= ')' ) | ( () ( (lv_action_19_0= 'Terminated' ) ) otherlv_20= '(' otherlv_21= 'obligations.' ( (otherlv_22= RULE_ID ) ) otherlv_23= ')' ) | ( () ( (lv_action_25_0= 'Triggered' ) ) otherlv_26= '(' otherlv_27= 'obligations.' ( (otherlv_28= RULE_ID ) ) otherlv_29= ')' ) | ( () ( (lv_action_31_0= 'Suspended' ) ) otherlv_32= '(' ( (lv_norm_33_0= 'self' ) ) otherlv_34= ')' ) | ( () ( (lv_action_36_0= 'Resumed' ) ) otherlv_37= '(' ( (lv_norm_38_0= 'self' ) ) otherlv_39= ')' ) | ( () ( (lv_action_41_0= 'Terminated' ) ) otherlv_42= '(' ( (lv_norm_43_0= 'self' ) ) otherlv_44= ')' ) )";
        }
    }
    static final String dfa_22s = "\13\uffff";
    static final String dfa_23s = "\3\uffff\1\10\1\uffff\1\12\5\uffff";
    static final String dfa_24s = "\1\4\2\uffff\1\15\1\uffff\1\15\5\uffff";
    static final String dfa_25s = "\1\75\2\uffff\1\162\1\uffff\1\162\5\uffff";
    static final String dfa_26s = "\1\uffff\1\1\1\2\1\uffff\1\5\1\uffff\1\7\1\3\1\4\1\6\1\10";
    static final String dfa_27s = "\13\uffff}>";
    static final String[] dfa_28s = {
            "\1\5\1\6\1\3\61\uffff\1\1\1\2\3\uffff\1\4",
            "",
            "",
            "\1\10\1\uffff\1\10\1\7\4\uffff\2\10\4\uffff\1\10\23\uffff\10\10\72\uffff\2\10",
            "",
            "\1\12\1\uffff\2\12\3\uffff\1\11\2\12\4\uffff\1\12\23\uffff\10\12\72\uffff\2\12",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = dfa_22;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "6592:2: ( ( () ( (lv_value_1_0= 'true' ) ) ) | ( () ( (lv_value_3_0= 'false' ) ) ) | ( () ( (lv_value_5_0= ruleDouble ) ) ) | ( () ( (lv_value_7_0= RULE_INT ) ) ) | ( () ( (lv_value_9_0= ruleDate ) ) ) | ( () ( (lv_enumeration_11_0= RULE_ID ) ) otherlv_12= '(' ( (lv_enumItem_13_0= RULE_ID ) ) otherlv_14= ')' ) | ( () ( (lv_value_16_0= RULE_STRING ) ) ) | ( () ( (lv_value_18_0= ruleVariableDotExpression ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00007E00030020F0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00007E00030000F2L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000005F031F0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x2380000000100070L,0xFFF8000000800000L,0x0000000000000007L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000000000F2L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000004F031F2L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000001E80004000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000001E80004002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000030001000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020001000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000010001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x000001E000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0xFF80000000100070L,0xFFF800000080003FL,0x0000000000000007L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xFF80000000100070L,0xFFF860000080003FL,0x0000000000000007L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xFF80000000100070L,0xFFF980000080003FL,0x0000000000000007L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0006000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0078000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x2380000000100070L,0xFFF8000000FBBF80L,0x0000000000000007L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x00000FFF80000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x000000007F000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000600000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0001800000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x000000000000A680L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000008000002L,0x0002000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000008002L,0x0004000000000000L});

}