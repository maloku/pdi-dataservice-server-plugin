package com.pentaho.di.trans.dataservice.optimization;

public class OptimizationImpactInfo {
  private String queryBeforeOptimization = "";
  private String queryAfterOptimization = "";
  private final String stepName;
  private boolean modified = false;
  private String errorMsg = "";

  public OptimizationImpactInfo( String stepName ) {
    this.stepName = stepName;
  }

  public String getQueryBeforeOptimization() {
    return queryBeforeOptimization == null || queryBeforeOptimization.trim().length() == 0
      ? "<no query>" : queryBeforeOptimization;
  }

  public void setQueryBeforeOptimization( String queryBeforeOptimization ) {
    this.queryBeforeOptimization = queryBeforeOptimization;
  }

  public String getQueryAfterOptimization() {
    return queryAfterOptimization;
  }

  public void setQueryAfterOptimization( String queryAfterOptimization ) {
    this.queryAfterOptimization = queryAfterOptimization;
  }

  public String getStepName() {
    return stepName;
  }

  public boolean isModified() {
    return modified;
  }

  public void setModified( boolean modified ) {
    this.modified = modified;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg( String errorMsg ) {
    this.errorMsg = errorMsg;
  }

  public String getDescription() {
    StringBuilder builder = new StringBuilder();
    builder
      .append( "Step:  " )
      .append( getStepName() )
      .append( "\n" );
    if ( getErrorMsg().length() > 0 ) {
      builder
        .append( "[ERROR]  " )
        .append( getErrorMsg() )
        .append( "\n" );
    }
    if ( isModified() ) {
      builder
        .append( "Before:\n     " )
        .append( getQueryBeforeOptimization() )
        .append( "\nAfter:\n     " )
        .append( getQueryAfterOptimization() );
    } else {
      builder
        .append( "[NO MODIFICATION]\n" )
        .append( "Query:\n     " )
        .append( getQueryBeforeOptimization() );
    }
    return builder.toString();
  }

}
