package interfaces;


public interface IIDEFactory {
   
   public IBuilder createBuilder();
   public ISyntaxHighlighter createSyntaxHighlighter();
   public String[] supportedExtensions();
}
